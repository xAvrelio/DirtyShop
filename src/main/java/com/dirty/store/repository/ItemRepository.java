package com.dirty.store.repository;

import com.dirty.store.entity.Item;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ItemRepository extends BaseRepository<Item> {

    @EntityGraph(value = "item_full_desc", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Item> findById(int id);
}
