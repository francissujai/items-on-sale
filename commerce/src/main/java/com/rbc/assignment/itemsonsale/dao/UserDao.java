package com.rbc.assignment.itemsonsale.dao;

import com.rbc.assignment.itemsonsale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
