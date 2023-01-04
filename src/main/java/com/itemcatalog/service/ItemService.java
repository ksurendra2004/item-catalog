package com.itemcatalog.service;

import com.itemcatalog.entity.ItemEntity;
import com.itemcatalog.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

   public ItemEntity addItem(ItemEntity itemEntity) throws Exception {
        /*Stream.of("Lining", "PUMA", "Bad Boy", "Air Jordan", "Nike1", "Adidas", "Reebok")
                .forEach(item -> itemRepository.save(new ItemEntity(item)));*/
        return itemRepository.save(itemEntity);
    }

    public String updateItem(ItemEntity itemEntity) throws Exception {

        return itemRepository.findById(itemEntity.getId()).map(item -> {
            item.setName(itemEntity.getName());
            itemRepository.save(item);
            return "Item id "+itemEntity.getId()+" has updated successfully";
        }).orElseGet(() -> "No record found on this item id "+itemEntity.getId());
    }

    public Collection<ItemEntity> getItems() throws Exception {
         return itemRepository.findAll();
    }

    public Optional<ItemEntity> getItem(Long itemId) throws Exception {
        return itemRepository.findById(itemId);
    }

    public void deleteItem(Long itemId) throws Exception {
        itemRepository.deleteById(itemId);
    }
}
