package com.rbc.assignment.itemsonsale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product implements Comparable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int category_id;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    private String name;

    private String description;

    private Double rating;

    private Integer num_of_reviews;

    private Boolean item_on_sale;

    private Timestamp last_updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getItem_on_sale() {
        return item_on_sale;
    }

    public void setItem_on_sale(Boolean item_on_sale) {
        this.item_on_sale = item_on_sale;
    }

    public Timestamp getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Timestamp last_updated) {
        this.last_updated = last_updated;
    }

    public Integer getNum_of_reviews() {
        return num_of_reviews;
    }

    public void setNum_of_reviews(Integer num_of_reviews) {
        this.num_of_reviews = num_of_reviews;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int compareTo(Object product) {
        return (int) (((this.rating != null) ? this.rating : 0) - ((((Product) product).rating) != null ? ((Product) product).rating : 0));
    }
}