package com.dirty.store.repository;

import com.dirty.store.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository repository;

    @Test
    void findById() {
        StringBuilder sb = new StringBuilder();
        Item item = repository.findById(1).orElse(null);
        assert item != null;
        sb.append("ID: ").append(item.getId()).append("\n");
        sb.append("Name: ").append(item.getName()).append("\n");
        sb.append("Full Desc: ").append(item.getFullDescription()).append("\n");
        sb.append("Short Desc: ").append(item.getShortDescription()).append("\n");
        sb.append("Price: ").append(item.getPrice()).append("\n");
        sb.append("Brand: ").append(item.getBrand().getName()).append("\n");
        sb.append("Category: ").append(item.getCategory().getName()).append("\n");
        sb.append("Condition: ").append(item.getItemCondition().getCondition().getName()).append(" ");
        sb.append("Condition Desc: ").append(item.getItemCondition().getDescription()).append("\n");
        sb.append("Item Specs: ").append("\n");
        item.getItemSpecs().forEach(itemSpec -> sb.append(itemSpec.getSpecific().getName()).append(" > ").append(itemSpec.getSpecValue().getValue()).append("\n"));
        System.out.println(item.getItemWarehouse().size());
        item.getItemWarehouse().forEach(itemWarehouse -> sb.append(itemWarehouse.getWarehouse().getName()).append(" > ").append(itemWarehouse.getStock()).append("\n"));
        sb.append("Condition: ").append(item.getItemCondition().getCondition().getName()).append(" ");

        System.out.println(sb);

    }
}