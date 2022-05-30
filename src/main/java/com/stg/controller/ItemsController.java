package com.stg.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Items;
import com.stg.service.ItemsService;

@RestController
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	@GetMapping(value = "/checkitems", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Items> checkItems(@RequestParam UUID itemId, @RequestParam String itemType) {

		Items items = itemsService.checkItems(itemId, itemType);

		return new ResponseEntity<Items>(items, HttpStatus.OK);

	}

	@GetMapping(value = "/fetchitems", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Items> fetchItemsList() {

		List<Items> items = itemsService.fetchItemsList();

		return new ResponseEntity<Items>((Items) items, HttpStatus.OK);
	}

	@PostMapping(value = "/additems", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Items> addItems(@RequestParam Items items) {

		Items items1 = itemsService.addItems(items);

		return new ResponseEntity<Items>(items1, HttpStatus.OK);

	}

	@GetMapping(value = "/checkstock", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkItemStock(@RequestParam String itemInStock) {

		boolean check = itemsService.checkItemStock(itemInStock);

		return new ResponseEntity<Boolean>(check, HttpStatus.OK);
	}

	@PutMapping(value = "/additems", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Items> updateItems(@RequestParam Items items) {

		Items items1 = itemsService.updateItems(items);

		return new ResponseEntity<Items>(items1, HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteitems", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Items> deleteByItemId(UUID itemId) {

		itemsService.deleteByItemId(itemId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
