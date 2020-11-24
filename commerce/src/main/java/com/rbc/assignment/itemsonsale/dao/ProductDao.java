package com.rbc.assignment.itemsonsale.dao;

import com.rbc.assignment.itemsonsale.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao  extends JpaRepository<Product, Integer> {

  String FIND_PRODUCTS = "SELECT * from products where category_id in (SELECT id FROM categories where id in (?1)) and item_on_sale = true";

  @Query(value = FIND_PRODUCTS, nativeQuery = true)
  List<Product> findProductsOnSale(List<Integer> categoryIds);
}