package com.rbc.assignment.itemsonsale.dao;

import com.rbc.assignment.itemsonsale.model.ProductRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRatingDao extends JpaRepository<ProductRating, Integer> {

  String FIND_RATING_USERS = "SELECT * from productratings where user_id = ?1 and product_id = ?2";

  @Query(value = FIND_RATING_USERS, nativeQuery = true)
  ProductRating findProductRatingForUser(int userId, int productId);
}