package com.stg.service;

import java.util.List;
import java.util.UUID;

import com.stg.entity.Items;

public interface ItemsService {

	public abstract Items checkItems(UUID itemId, String itemType); // validation

	public abstract List<Items> fetchItemsList(); // read

	public abstract Items addItems(Items items); // add

	public abstract boolean checkItemStock(String itemInStock); // search

	public abstract Items updateItems(Items items); // update

	public abstract void deleteByItemId(UUID itemId); // delete

}
