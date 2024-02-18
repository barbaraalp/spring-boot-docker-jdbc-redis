package com.example.myspringbootapp.repository;

import com.example.myspringbootapp.model.FoodListing;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface FoodListingRepository extends CrudRepository<FoodListing, Long> {

}
