package com.dirty.store.entity;

import com.dirty.store.entity.base.NamedIndexEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(name = "items")
@Where(clause = "is_active = true")
@NamedEntityGraph(
        name = "item_full_desc",
        attributeNodes = {@NamedAttributeNode("fullDescription"), @NamedAttributeNode("photos"),
                @NamedAttributeNode("brand"), @NamedAttributeNode(value = "itemCondition", subgraph = "itemCondition.name"),
                @NamedAttributeNode("itemReturnPolicy"), @NamedAttributeNode(value = "itemWarehouse", subgraph = "itemWarehouse.name"),
                @NamedAttributeNode("category"), @NamedAttributeNode("itemSpecs")},
        subgraphs = {@NamedSubgraph(name = "itemCondition.name",
                attributeNodes = @NamedAttributeNode(value = "condition")),
                @NamedSubgraph(name = "itemWarehouse.name",
                        attributeNodes = @NamedAttributeNode(value = "warehouse"))}
)
public class Item extends NamedIndexEntity {

    /*
        TODO:Rewrite to use currency API
     */
    @Column(name = "price", nullable = false, columnDefinition = "NUMERIC(8, 2) DEFAULT 0.00")
    private BigDecimal price;

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive;

    @Column(name = "short_description", nullable = false, columnDefinition = "TEXT CHECK (length(short_description) >= 2)")
    private String shortDescription;

    @ToString.Exclude
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "full_description", nullable = false, columnDefinition = "TEXT CHECK (length(full_description) >= 2)")
    private String fullDescription;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Photo> photos;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ItemWarehouse> itemWarehouse;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "item")
    private ItemCondition itemCondition;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "item")
    private ItemReturnPolicy itemReturnPolicy;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ItemSpec> itemSpecs;
}
