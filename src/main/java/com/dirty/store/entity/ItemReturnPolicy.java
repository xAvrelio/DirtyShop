package com.dirty.store.entity;

import com.dirty.store.entity.base.IndexEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "item_return_polices")
public class ItemReturnPolicy extends IndexEntity {

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "return_policy_id")
    private ReturnPolicy returnPolicy;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT CHECK (length(description) >= 2)")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @ToString.Exclude
    private Item item;
}
