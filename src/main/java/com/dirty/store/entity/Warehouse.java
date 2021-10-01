package com.dirty.store.entity;

import com.dirty.store.entity.base.NamedIndexEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "warehouse")
public class Warehouse extends NamedIndexEntity {

    @Column(name = "address")
    private String address;


}
