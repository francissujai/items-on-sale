package com.rbc.assignment.itemsonsale.service;

import com.rbc.assignment.itemsonsale.dao.FavouritesDao;
import com.rbc.assignment.itemsonsale.dao.OrderDao;
import com.rbc.assignment.itemsonsale.dao.ProductDao;
import com.rbc.assignment.itemsonsale.model.Favourites;
import com.rbc.assignment.itemsonsale.model.Order;
import com.rbc.assignment.itemsonsale.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service Implementation class for handling the product recommendation functions.
 */
@Service
public class RecommendationService {

  @Autowired
  private OrderDao orderDao;

  @Autowired
  private ProductDao productDao;

  @Autowired
  private FavouritesDao favouritesDao;

  /**
   * Service Method for preparing the recommendations.
   *
   * @param userId {@link Integer}
   * @return {@link Order}
   */
  public List<Product> getRecommendedProducts(final int userId) {
    int productCount = 0;
    List<Product> productRating = new ArrayList<>();
    Set<Integer> ratedCategory = new HashSet<>();
    // Step 1 : Get all the orders for this user
    // We are invoking the DAO layer for getting the list of orders for this user.
    List<Order> ordersForGivenUser = orderDao.findOrdersByUserId(userId);
    // Step 2 : Iterate through the list of orders and get the ratings for the products
    for (Order order : ordersForGivenUser) {
      Set<Product> productsInThisOrder = order.getProducts();
      // Add all the products to a list.
      for (Product product : productsInThisOrder) {
        productRating.add(product);
      }
    }

    // Step 3 : Get all the user's favourite products
    List<Favourites> favouriteProducts = favouritesDao.findFavouritesByUserId(userId);

    // Iterate the user's favourite products and add the products to the productRating list
    for (Favourites favourites : favouriteProducts) {
      productRating.add(productDao.findById(favourites.getProduct_id()).get());
    }

    // Step 4 : Sort the products based on the rating, Product object implements the Comparable interface
    // and Override the CompareTo method to compare against rating.
    Collections.sort(productRating);

    // Step 5
    // Assumption : We consider the top 5 highly rated products for getting the respective categories
    // For instance, if all top 5 products are from same category, we will have only one top rated category
    // to find the recommended products from that category.
    for (Product product : productRating) {
      // We are using hashset to make sure we don't have duplicate categories.
      ratedCategory.add(product.getCategory_id());
      productCount ++;
      if (productCount > 4) {
        break;
      }
    }

    // Step 6 : Get the list of products which are on sale based on the top rankings of the categories
    return productDao.findProductsOnSale(new ArrayList<>(ratedCategory));
  }
}