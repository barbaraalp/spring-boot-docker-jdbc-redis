package com.example.myspringbootapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("food_listing")
public class FoodListing {

    @Id
    private Long id;
    
    @Column("establishment_name")
    private String establishmentName;
    
    @Column("food_type")
    private String foodType;
    
    private String location;
    
    private double price;
    
    @Column("quantity_available")
    private int quantityAvailable;
    
    private String description;

    // Getters and setters
}