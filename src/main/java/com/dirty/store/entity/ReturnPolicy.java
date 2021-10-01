package com.dirty.store.entity;

import com.dirty.store.entity.base.NamedIndexEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "return_polices")
public class ReturnPolicy extends NamedIndexEntity {

}
