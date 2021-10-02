package com.dirty.store.entity;

import com.dirty.store.entity.base.IndexEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "item_conditions")
public class ItemCondition extends IndexEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_id")
    @ToString.Exclude
    private Condition condition;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT CHECK (length(description) >= 2)")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @ToString.Exclude
    private Item item;

}
