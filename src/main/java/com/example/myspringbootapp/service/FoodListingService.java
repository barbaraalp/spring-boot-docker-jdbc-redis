package com.example.myspringbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.myspringbootapp.model.FoodListing;
import com.example.myspringbootapp.repository.FoodListingRepository;

import java.util.List;

@Service
public class FoodListingService {

    private final FoodListingRepository foodListingRepository;

    @Autowired
    public FoodListingService(FoodListingRepository foodListingRepository) {
        this.foodListingRepository = foodListingRepository;
    }
    
    @Cacheable(value = "foodListings")
    public List<FoodListing> getAllFoodListings() {
        List<FoodListing> foodListings = (List<FoodListing>) foodListingRepository.findAll();
        return foodListings;    
    }

    @Cacheable(value = "foodListing", key = "#id")
    public FoodListing getFoodListingById(Long id) {
        return foodListingRepository.findById(id).orElse(null);
    }
}
