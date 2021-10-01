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

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT CHECK (length(description) >= 10)")
    private String description;


}
