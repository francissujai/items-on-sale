package com.rbc.assignment.itemsonsale.model;

import javax.persistence.*;

@Entity
@Table(name = "productratings")
public class ProductRating {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int user_id;

    private int product_id;

    private Double rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
