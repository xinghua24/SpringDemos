package com.xinghua24.springdocopenapi.repository;

import com.xinghua24.springdocopenapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
