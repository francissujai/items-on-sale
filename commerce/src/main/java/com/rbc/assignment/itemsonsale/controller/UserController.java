package com.rbc.assignment.itemsonsale.controller;

import com.rbc.assignment.itemsonsale.dao.UserDao;
import com.rbc.assignment.itemsonsale.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Rest controller exposing api for user related operations.
 */
@RestController
@RequestMapping("/items-on-sale/api/v1/users")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Rest method for user signup.
     *
     * @param user {@link User}
     */
    @PostMapping(value="/signup")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreatedAt(new Timestamp(new Date().getTime()));
        user.setUpdatedAt(new Timestamp(new Date().getTime()));
        userDao.save(user);
    }
}