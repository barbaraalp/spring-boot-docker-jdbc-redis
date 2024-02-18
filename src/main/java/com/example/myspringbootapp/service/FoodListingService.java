package com.example.myspringbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.myspringbootapp.model.FoodListing;
import com.example.myspringbootapp.repository.FoodListingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@Service
public class FoodListingService {

    private final FoodListingRepository foodListingRepository;
    private static final Logger logger = LoggerFactory.getLogger(FoodListingService.class);

    @Autowired
    public FoodListingService(FoodListingRepository foodListingRepository) {
        this.foodListingRepository = foodListingRepository;
    }

    @Cacheable(value = "foodListings", key = "'allFoodListings'")
    public List<FoodListing> getAllFoodListings() {
        logger.info("Sem cache :D");
        List<FoodListing> foodListings = (List<FoodListing>) foodListingRepository.findAll();
        return foodListings;    
    }

    public FoodListing getFoodListingById(Long id) {
        return foodListingRepository.findById(id).orElse(null);
    }
}
