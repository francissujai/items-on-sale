package com.rbc.assignment.itemsonsale.dao;

import com.rbc.assignment.itemsonsale.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    String FIND_CATEGORIES = "SELECT name from categories where id in (SELECT category_id FROM products where id = ?1)";

    @Query(value = FIND_CATEGORIES, nativeQuery = true)
    Category findCategoryForProduct(long productId);
}