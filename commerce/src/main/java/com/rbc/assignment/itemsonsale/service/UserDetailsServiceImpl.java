package com.rbc.assignment.itemsonsale.service;

import com.rbc.assignment.itemsonsale.dao.UserDao;
import com.rbc.assignment.itemsonsale.exception.ResourceNotFoundException;
import com.rbc.assignment.itemsonsale.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException(username+" NOT Found!"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }

    /**
     * Method to check whether user is in good status or not.
     *
     * @param userId {@link Integer}
     */
    public boolean isUserInGoodStatus(final Integer userId) {
        // Assumption is, if the user is found in the system, then we assume user is in good status.
        User user = userDao.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(userId+" NOT Found!"));
        return true;
    }
}