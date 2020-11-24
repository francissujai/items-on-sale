package com.rbc.assignment.itemsonsale.dao;

import com.rbc.assignment.itemsonsale.model.Order;
import com.rbc.assignment.itemsonsale.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

    String FIND_ORDERS = "SELECT * FROM orders where user_id = ?1";

    @Query(value = FIND_ORDERS, nativeQuery = true)
    List<Order> findOrdersByUserId(final int userId);
}