package com.dirty.store.entity;

import com.dirty.store.entity.base.NamedIndexEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "brands")
public class Brand extends NamedIndexEntity {

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    private List<Item> items;
}
