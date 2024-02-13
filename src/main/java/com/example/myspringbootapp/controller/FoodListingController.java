package com.example.myspringbootapp.controller;

import com.example.myspringbootapp.model.FoodListing;
import com.example.myspringbootapp.service.FoodListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food-listings")
public class FoodListingController {

    private final FoodListingService foodListingService;
    private static final Logger logger = LoggerFactory.getLogger(FoodListingService.class);


    @Autowired
    public FoodListingController(FoodListingService foodListingService) {
        this.foodListingService = foodListingService;
    }

    @GetMapping
    public List<FoodListing> getAllFoodListings() {
        long startTime = System.currentTimeMillis();
        List<FoodListing> foodListings = foodListingService.getAllFoodListings();
        long endTime = System.currentTimeMillis();
        logger.info("getAllFoodListings executed in {} milliseconds", endTime - startTime);
        return foodListings;
    }

    @GetMapping("/{id}")
    public FoodListing getFoodListingById(@PathVariable Long id) {
        return foodListingService.getFoodListingById(id);
    }
}
