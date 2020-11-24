package com.rbc.assignment.itemsonsale.service;

import com.rbc.assignment.itemsonsale.dao.ProductDao;
import com.rbc.assignment.itemsonsale.exception.ResourceNotFoundException;
import com.rbc.assignment.itemsonsale.model.Product;
import com.rbc.assignment.itemsonsale.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class ProductService {

  @Autowired
  ProductDao productDao;

  /**
   * Service Method for creating a product.
   *
   * @param product {@link Product}
   * @return {@link ProductResponse}
   */
  public ProductResponse createProduct(final Product product) {
    // We are invoking the DAO layer for saving the product in to the DB.
    product.setLast_updated(new Timestamp((new Date()).getTime()));
    Product createdProduct = productDao.save(product);
    // Creating the response object that needs to be sent in the response entity,
    ProductResponse productResponse = new ProductResponse();
    productResponse.setProductId(createdProduct.getId());
    return productResponse;
  }

  /**
   * Service Method for updating a product.
   *
   * @param product {@link Product}
   * @return {@link ProductResponse}
   */
  public ProductResponse updateProduct(int id, final Product product) {
    // We are invoking the DAO layer for updating the product in to the DB.
    Product productById = productDao.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Product with ID :"+id+" Not Found!"));
    productById.setLast_updated(new Timestamp((new Date()).getTime()));
    // We are updating only the item on sale flag for this product.
    productById.setItem_on_sale(product.getItem_on_sale());
    Product updatedProduct = productDao.save(productById);
    // Creating the response object that needs to be sent in the response entity,
    ProductResponse productResponse = new ProductResponse();
    productResponse.setProductId(updatedProduct.getId());
    return productResponse;
  }
}
