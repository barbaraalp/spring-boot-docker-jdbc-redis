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

    @Cacheable(value = "foodListings", key = "'allFoodListings'")
    public List<FoodListing> getAllFoodListings() {
        return (List<FoodListing>) foodListingRepository.findAll();
    }

    public FoodListing getFoodListingById(Long id) {
        return foodListingRepository.findById(id).orElse(null);
    }

    public List<FoodListing> getFoodListingsByLocation(String location) {
        return foodListingRepository.findByLocation(location);
    }

    public FoodListing saveFoodListing(FoodListing foodListing) {
        return foodListingRepository.save(foodListing);
    }

    public void deleteFoodListing(Long id) {
        foodListingRepository.deleteById(id);
    }
}
