package com.rbc.assignment.itemsonsale.dao;

import com.rbc.assignment.itemsonsale.model.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouritesDao extends JpaRepository<Favourites, Integer> {

    String FIND_FAVOURITES = "SELECT * FROM Favourites where user_id =?1";

    @Query(value = FIND_FAVOURITES, nativeQuery = true)
    List<Favourites> findFavouritesByUserId(final int userId);
}