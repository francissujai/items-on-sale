package com.rbc.assignment.itemsonsale.service;

import com.rbc.assignment.itemsonsale.dao.CategoryDao;
import com.rbc.assignment.itemsonsale.model.Category;
import com.rbc.assignment.itemsonsale.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  CategoryDao categoryDao;

  /**
   * Service Method for getting the category for the product.
   *
   * @param productId {@link Long}
   * @return {@link CategoryResponse}
   */
  public CategoryResponse getCategoryForProduct(final long productId) {
    // We are invoking the DAO layer for getting the category from the DB for the given product id.
    Category category = categoryDao.findCategoryForProduct(productId);
    // Creating the response object that needs to be sent in the response entity,
    CategoryResponse categoryResponse = new CategoryResponse();
    categoryResponse.setCategoryName(category.getName());
    return categoryResponse;
  }

  /**
   * Service Method for creating a category.
   *
   * @param category {@link Category}
   * @return {@link CategoryResponse}
   */
  public CategoryResponse createProduct(final Category category) {
    // We are invoking the DAO layer for saving the category in to the DB.
    Category createdCategory = categoryDao.save(category);
    // Creating the response object that needs to be sent in the response entity,
    CategoryResponse categoryResponse = new CategoryResponse();
    categoryResponse.setCategoryName(createdCategory.getName());
    return categoryResponse;
  }
}