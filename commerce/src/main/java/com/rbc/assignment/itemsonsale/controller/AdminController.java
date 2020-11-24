package com.rbc.assignment.itemsonsale.controller;

import com.rbc.assignment.itemsonsale.model.Category;
import com.rbc.assignment.itemsonsale.model.Product;
import com.rbc.assignment.itemsonsale.service.CategoryService;
import com.rbc.assignment.itemsonsale.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Rest Controller for exposing APIs to support the admin initiated actions.
 */
@RestController
@RequestMapping("/items-on-sale/api/v1/admin")
@Validated
public class AdminController {
    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     *  Rest method for creating a product.
     *
     * @param product {@link Product}
     * @return {@link ResponseEntity}
     */
    @PostMapping(value="/products")
    ResponseEntity<?> addProduct( @Valid @RequestBody Product product) {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    /**
     *  Rest method for updating a product e.g. add the item-on-sale flag.
     *
     * @param id product id
     * @param product product body
     * @return Updated product response is returned
     */
    @PutMapping(value="/products/{id}")
    ResponseEntity<?> updateProduct(@PathVariable("id")  @Min(1) int id, @Valid @RequestBody Product product) {
        return ResponseEntity.ok().body(productService.updateProduct(id, product));

    }

    /**
     *  Rest method for creating a category.
     *
     * @param category {@link Category}
     * @return {@link ResponseEntity}
     */
    @PostMapping(value="/categories")
    ResponseEntity<?> addCategory( @Valid @RequestBody Category category) {
        return ResponseEntity.ok().body(categoryService.createProduct(category));
    }
}