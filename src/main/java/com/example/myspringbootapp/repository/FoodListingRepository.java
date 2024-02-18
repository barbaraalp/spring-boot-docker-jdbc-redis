package com.example.myspringbootapp.repository;

import com.example.myspringbootapp.model.FoodListing;
import org.springframework.data.repository.CrudRepository;

public interface FoodListingRepository extends CrudRepository<FoodListing, Long> {

}
