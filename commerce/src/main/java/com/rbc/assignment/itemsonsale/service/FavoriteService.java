package com.rbc.assignment.itemsonsale.service;

import com.rbc.assignment.itemsonsale.dao.FavouritesDao;
import com.rbc.assignment.itemsonsale.model.Favourites;
import com.rbc.assignment.itemsonsale.response.FavouriteProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

  @Autowired
  FavouritesDao favouritesDao;

  /**
   * Service method for saving a product as user's favourite
   *
   * @param favourites {@link Favourites}
   * @return product rating response {@link FavouriteProductResponse}
   */
  public FavouriteProductResponse saveAsFavourite(final Favourites favourites) {
    // We are invoking the DAO layer for saving the favourite product in to the DB.
    Favourites savedFavourites = favouritesDao.save(favourites);

    // Creating the response object that needs to be sent in the response entity,
    final FavouriteProductResponse favouriteProductResponse = new FavouriteProductResponse();
    favouriteProductResponse.setFavouriteId(savedFavourites.getId());
    return favouriteProductResponse;
  }

  /**
   * Service Method for finding the user's favourite products.
   *
   * @param userId {@link Integer}
   * @return {@link Favourites}
   */
  public List<Favourites> getFavouritesByUserId(final int userId) {
    return favouritesDao.findFavouritesByUserId(userId);
  }
}