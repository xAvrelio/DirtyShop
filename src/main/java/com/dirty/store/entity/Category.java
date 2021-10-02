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
@Table(name = "category")
/*
@NamedEntityGraph(name = "category.subCategories",
        attributeNodes = {@NamedAttributeNode(value = "subCategories")}
)
 */
public class Category extends NamedIndexEntity {

    @Column(name = "description", columnDefinition = "TEXT CHECK (length(description) >= 2)")
    private String description;


    @Column(name = "parent_id", columnDefinition = "integer constraint category_parent_idx references category")
    private Integer parentId;


/*
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

  //  @BatchSize(size = 15)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentCategory")
    private Set<Category> subCategories = new HashSet<>();

 */

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Item> items;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Specific> specifics;


}
