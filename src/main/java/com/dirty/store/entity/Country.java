package com.dirty.store.entity;

import com.dirty.store.entity.base.NamedIndexEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "countries")
public class Country extends NamedIndexEntity {

    /*
        TODO:Rewrite to use currency API
     */

    @Column(name = "code", columnDefinition = "VARCHAR(5) CHECK (length(code) = 5)")
    private String code;

    @Column(name = "english_name", columnDefinition = "VARCHAR(128) CHECK (length(english_name) >= 2)")
    private String englishName;


    @Column(name = "tax_rate", columnDefinition = "REAL DEFAULT 0")
    private BigDecimal taxRate;

}
