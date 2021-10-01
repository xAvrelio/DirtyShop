package com.dirty.store.entity.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NamedIndexEntity extends IndexEntity {

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(128) CHECK (length(name) >= 2)")
    protected String name;

    protected NamedIndexEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '[' + name + ']';
    }
}
