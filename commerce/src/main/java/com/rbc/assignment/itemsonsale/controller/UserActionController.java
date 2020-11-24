package com.rbc.assignment.itemsonsale.controller;

import com.rbc.assignment.itemsonsale.model.Favourites;
import com.rbc.assignment.itemsonsale.model.Order;
import com.rbc.assignment.itemsonsale.model.Product;
import com.rbc.assignment.itemsonsale.model.ProductRating;
import com.rbc.assignment.itemsonsale.service.CategoryService;
import com.rbc.assignment.itemsonsale.service.FavoriteService;
import com.rbc.assignment.itemsonsale.service.OrderService;
import com.rbc.assignment.itemsonsale.service.ProductRatingService;
import com.rbc.assignment.itemsonsale.service.RecommendationService;
import com.rbc.assignment.itemsonsale.service.UserDetailsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Rest Controller for exposing APIs to support the user initiated actions.
 */
@RestController
@RequestMapping("/items-on-sale/api/v1/user/actions")
@Validated
public class UserActionController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRatingService productRatingService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private RecommendationService recommendationService;

    /**
     *  Rest method for placing an order.
     *
     * @param order {@link Order}
     * @return {@link ResponseEntity}
     */
    @PostMapping(value="/order")
    ResponseEntity<?> placeOrder( @Valid @RequestBody Order order) {
        return ResponseEntity.ok().body(orderService.createOrder(order));
    }

    /**
     *  Rest method for getting orders by user id.
     *
     * @return {@link ResponseEntity}
     */
    @GetMapping(value="/orders/{userId}")
    ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable("userId") @Min(1) int userId) {
        return ResponseEntity.ok().body(orderService.getOrdersByUserId(userId));
    }

    /**
     *  Rest method for rating a product.
     *
     * @param productRating {@link ProductRating}
     * @return {@link ResponseEntity}
     */
    @PostMapping(value="/product/rate")
    ResponseEntity<?> rateProduct( @Valid @RequestBody ProductRating productRating) {
        return ResponseEntity.ok().body(productRatingService.saveRating(productRating));
    }

    /**
     *  Rest method for making a product as user's favourite.
     *
     * @param favourite {@link Favourites}
     * @return {@link ResponseEntity}
     */
    @PostMapping(value="/favourites")
    ResponseEntity<?> addProductAsFavourite( @Valid @RequestBody Favourites favourite) {
        return ResponseEntity.ok().body(favoriteService.saveAsFavourite(favourite));
    }

    /**
     *  Rest method for getting the list of user's favourite products.
     *
     * @return {@link ResponseEntity}
     */
    @GetMapping(value="/favourites/{userId}")
    ResponseEntity<List<Favourites>> getFavouritesByUserId(@PathVariable("userId") @Min(1) int userId) {
        return ResponseEntity.ok().body(favoriteService.getFavouritesByUserId(userId));
    }

    /**
     * Rest method to get all the categories for the given products
     *
     * @param productId
     * @return all the categories for the given product id.
     */
    @GetMapping(value="/category/{productId}")
    ResponseEntity<?> getCategoryForProduct(@PathVariable("productId") final long productId) {
        return ResponseEntity.ok().body(categoryService.getCategoryForProduct(productId));
    }

    /**
     * Rest method to get the recommended products for a user.
     *
     * @return recommended products.
     */
    @GetMapping(value="/recommendations/products/{userId}")
    ResponseEntity<List<Product>> getRecommendedProductsForUser(@PathVariable("userId") @Min(1) final Integer userId) {
        // Check the validity of the user based on user id
        userDetailsService.isUserInGoodStatus(userId);
        return ResponseEntity.ok().body(recommendationService.getRecommendedProducts(userId));
    }
}