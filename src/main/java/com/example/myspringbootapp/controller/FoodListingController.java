package com.example.myspringbootapp.controller;

import com.example.myspringbootapp.model.FoodListing;
import com.example.myspringbootapp.service.FoodListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food-listings")
public class FoodListingController {

    private final FoodListingService foodListingService;

    @Autowired
    public FoodListingController(FoodListingService foodListingService) {
        this.foodListingService = foodListingService;
    }

    @GetMapping
    public List<FoodListing> getAllFoodListings() {
        return foodListingService.getAllFoodListings();
    }

    @GetMapping("/{id}")
    public FoodListing getFoodListingById(@PathVariable Long id) {
        return foodListingService.getFoodListingById(id);
    }

    @GetMapping("/location/{location}")
    public List<FoodListing> getFoodListingsByLocation(@PathVariable String location) {
        return foodListingService.getFoodListingsByLocation(location);
    }

    // Outros métodos aqui (POST, PUT, DELETE, etc.)
}
