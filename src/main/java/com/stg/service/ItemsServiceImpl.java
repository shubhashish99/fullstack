package com.stg.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import com.stg.entity.Items;
import com.stg.exception.ItemsException;
import com.stg.repository.ItemsRepository;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public Items checkItems(UUID itemId, String itemType) {

		Items items = itemsRepository.findByItemIdandItemType(itemId, itemType);
		if (items == null) {

			throw new ItemsException("Item not found!");
		} else {
			return items;
		}
	}

	@Override
	public List<Items> fetchItemsList() {

		return itemsRepository.findAll();
	}

	@Override
	public Items addItems(Items items) {

		return itemsRepository.save(items);
	}

	@Override
	public boolean checkItemStock(String itemInStock) {

		if (itemInStock != null)
			return true;
		else {
			return false;
		}
	}

	@Override
	public Items updateItems(Items items) {

		return itemsRepository.save(items);
	}

	@Override
	public void deleteByItemId(UUID itemId) {

		itemsRepository.deleteById(itemId);
	}

}
