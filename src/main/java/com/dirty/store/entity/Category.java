package com.dirty.store.entity;

import com.dirty.store.entity.base.NamedIndexEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "category")
public class Category extends NamedIndexEntity {

    @Column(name = "description", columnDefinition = "TEXT CHECK (length(description) >= 10)")
    private String description;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
    private Set<Category> subCategories = new HashSet<>();

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Item> items;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Specific> specifics;

}
