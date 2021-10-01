package com.dirty.store.entity;

import com.dirty.store.entity.base.NamedIndexEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(name = "items")
@Where(clause = "is_active = true")
public class Item extends NamedIndexEntity {

    /*
        TODO:Rewrite to use currency API
     */
    @Column(name = "price", nullable = false, columnDefinition = "NUMERIC(8, 2) DEFAULT 0.00")
    private BigDecimal price;

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive;

    @Column(name = "short_description", nullable = false, columnDefinition = "TEXT CHECK (length(short_description) >= 10)")
    private String shortDescription;

    @Column(name = "full_description", nullable = false, columnDefinition = "TEXT CHECK (length(full_description) >= 10)")
    private String fullDescription;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OrderBy(value = "ordId")
    private List<Photo> photos;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_id")
    private ItemCondition condition;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "return_policy_id")
    private ItemReturnPolicy returnPolicy;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private ItemWarehouse itemWarehouse;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ItemSpec> itemSpecs;
}
