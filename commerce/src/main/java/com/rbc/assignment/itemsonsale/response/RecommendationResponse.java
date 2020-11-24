package com.rbc.assignment.itemsonsale.response;

import com.rbc.assignment.itemsonsale.model.Product;

import java.util.List;

public class RecommendationResponse {

  private List<Product> recommendedProducts;

  public List<Product> getRecommendedProducts() {
    return recommendedProducts;
  }

  public void setRecommendedProducts(List<Product> recommendedProducts) {
    this.recommendedProducts = recommendedProducts;
  }
}