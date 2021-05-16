package com.springmvc.app.services;

import com.springmvc.app.domain.Item;
import com.springmvc.app.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServce {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItemsRecords() {
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }

    public void saveItemIntoDB(Item item) {
        this.itemRepository.save(item);
    }
}
