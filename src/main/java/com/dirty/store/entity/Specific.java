package com.dirty.store.entity;

import com.dirty.store.entity.base.NamedIndexEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "specifics")
public class Specific extends NamedIndexEntity {
    /*
        TODO: Add support Option type like checkbox, etc....
     */

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "specific")
    private List<SpecValue> specValues;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
