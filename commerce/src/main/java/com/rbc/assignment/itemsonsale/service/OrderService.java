package com.rbc.assignment.itemsonsale.service;

import com.rbc.assignment.itemsonsale.dao.OrderDao;
import com.rbc.assignment.itemsonsale.dao.ProductDao;
import com.rbc.assignment.itemsonsale.model.Order;
import com.rbc.assignment.itemsonsale.model.Product;
import com.rbc.assignment.itemsonsale.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service Implementation class for handling order related functions.
 */
@Service
public class OrderService {

  @Autowired
  OrderDao orderDao;

  @Autowired
  ProductDao productDao;

  /**
   * Service Method for creating a order.
   *
   * @param order {@link Order}
   * @return {@link Order}
   */
  public OrderResponse createOrder(final Order order) {
    // We are adding references to products to the created order
    Set<Product> orderedProducts = new HashSet<>();
    order.getProducts().forEach(product -> {
      orderedProducts.add(productDao.findById(product.getId()).get());
    });
    order.setProducts(orderedProducts);
    // We are invoking the DAO layer for saving the order in to the DB.
    Order createdOrder = orderDao.save(order);

    // Creating the response object that needs to be sent in the response entity,
    OrderResponse orderResponse = new OrderResponse();
    orderResponse.setOrderId(createdOrder.getId());
    return orderResponse;
  }

  /**
   * Service Method for finding orders by user id.
   *
   * @param userId {@link Integer}
   * @return {@link Order}
   */
  public List<Order> getOrdersByUserId(final int userId) {
    return orderDao.findOrdersByUserId(userId);
  }
}