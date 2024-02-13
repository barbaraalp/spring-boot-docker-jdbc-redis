package com.example.myspringbootapp.service;

import com.example.myspringbootapp.model.FoodListing;
import com.example.myspringbootapp.repository.FoodListingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FoodListingServiceTest {

    @Mock
    private FoodListingRepository foodListingRepository;

    @InjectMocks
    private FoodListingService foodListingService;

    @Test
    public void testGetAllFoodListings() {
        // Mocking repository response
        List<FoodListing> mockListings = new ArrayList<>();
        mockListings.add(new FoodListing());
        mockListings.add(new FoodListing());
        when(foodListingRepository.findAll()).thenReturn(mockListings);

        // Calling service method
        List<FoodListing> result = foodListingService.getAllFoodListings();

        // Verifying that the service method returns the mocked list
        assertEquals(2, result.size());
        verify(foodListingRepository, times(1)).findAll();
    }

    @Test
    public void testGetFoodListingById() {
        // Mocking repository response
        FoodListing mockListing = new FoodListing();
        mockListing.setId(1L);
        when(foodListingRepository.findById(1L)).thenReturn(Optional.of(mockListing));

        // Calling service method
        FoodListing result = foodListingService.getFoodListingById(1L);

        // Verifying that the service method returns the mocked listing
        assertEquals(1L, result.getId());
        verify(foodListingRepository, times(1)).findById(1L);
    }
}
