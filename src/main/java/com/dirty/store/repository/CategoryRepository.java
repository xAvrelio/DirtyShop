package com.dirty.store.repository;

import com.dirty.store.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface CategoryRepository extends BaseRepository<Category> {

    //    @EntityGraph(value = "category.subCategories", type = EntityGraph.EntityGraphType.FETCH)
    //   List<Category> findByParentCategoryIsNull();

}
