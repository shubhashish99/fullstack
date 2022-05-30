package com.stg.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {

	public Items findByItemIdandItemType(UUID itemId, String itemType);

	public void deleteById(UUID itemId);
}
