package com.rbc.assignment.itemsonsale.service;

import com.rbc.assignment.itemsonsale.dao.ProductDao;
import com.rbc.assignment.itemsonsale.dao.ProductRatingDao;
import com.rbc.assignment.itemsonsale.exception.ProductAlreadyRatedException;
import com.rbc.assignment.itemsonsale.model.Product;
import com.rbc.assignment.itemsonsale.model.ProductRating;
import com.rbc.assignment.itemsonsale.response.ProductRatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductRatingService {

  @Autowired
  private ProductRatingDao productRatingDao;

  @Autowired
  private ProductDao productDao;

  /**
   * Service method for saving the rating for a product.
   *
   * @param productRating {@link ProductRating}
   * @return product rating response {@link ProductRatingResponse}
   */
  public ProductRatingResponse saveRating(final ProductRating productRating) {

    // Step 1
    // We are invoking the DAO layer to see whether this user has already rated this product or not.
    ProductRating existingProductRating = productRatingDao.findProductRatingForUser(productRating.getUser_id(), productRating.getProduct_id());
    if (existingProductRating != null) {
      throw new ProductAlreadyRatedException("User has already Rated this product.");
    }

    // Step 2
    // We are invoking the DAO layer to add the rating for this product by this user.
    ProductRating savedProductRating = productRatingDao.save(productRating);

    // Step 3
    final Product product = productDao.findById(productRating.getProduct_id()).get();
    // Incrementing the number of reviews by one

    product.setNum_of_reviews((product.getNum_of_reviews() != null ? product.getNum_of_reviews() : 0)  + 1);

    // Setting the cumulative rating for the product.
    product.setRating(((product.getRating() != null ? product.getRating() * (product.getNum_of_reviews() - 1) : 0) + productRating.getRating()) / product.getNum_of_reviews());
    productDao.save(product);

    // Step 4
    // Creating the response object that needs to be sent in the response entity,
    final ProductRatingResponse productRatingResponse = new ProductRatingResponse();
    productRatingResponse.setRatingId(savedProductRating.getId());
    return productRatingResponse;
  }
}