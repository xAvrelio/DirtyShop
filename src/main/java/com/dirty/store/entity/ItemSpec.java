package com.dirty.store.entity;

import com.dirty.store.entity.base.IndexEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "item_specs")
public class ItemSpec extends IndexEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spec_value_id")
    private SpecValue specValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spec_id")
    private Specific specific;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

}
