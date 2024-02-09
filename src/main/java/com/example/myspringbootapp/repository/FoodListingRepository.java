package com.example.myspringbootapp.repository;

import com.example.myspringbootapp.model.FoodListing;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface FoodListingRepository extends CrudRepository<FoodListing, Long> {

    // Método para encontrar todas as listagens de comida em uma determinada localização
    @Query("SELECT * FROM food_listing WHERE location = :location")
    List<FoodListing> findByLocation(String location);

    // Método para encontrar todas as listagens de comida de um determinado estabelecimento
    @Query("SELECT * FROM food_listing WHERE establishment_name = :establishmentName")
    List<FoodListing> findByEstablishmentName(String establishmentName);

    // Método para encontrar todas as listagens de comida de um determinado tipo com preço menor que o especificado
    @Query("SELECT * FROM food_listing WHERE food_type = :foodType AND price < :maxPrice")
    List<FoodListing> findByFoodTypeAndPriceLessThan(String foodType, BigDecimal maxPrice);

    // Método para encontrar todas as listagens de comida disponíveis com quantidade maior que zero
    @Query("SELECT * FROM food_listing WHERE quantity_available > :minQuantity")
    List<FoodListing> findByQuantityAvailableGreaterThan(int minQuantity);

    // Método para encontrar todas as listagens de comida de um determinado tipo ordenadas por preço
    @Query("SELECT * FROM food_listing WHERE food_type = :foodType ORDER BY price ASC")
    List<FoodListing> findByFoodTypeOrderByPriceAsc(String foodType);

    // Método para encontrar todas as listagens de comida de um determinado tipo ordenadas por quantidade disponível
    @Query("SELECT * FROM food_listing WHERE food_type = :foodType ORDER BY quantity_available DESC")
    List<FoodListing> findByFoodTypeOrderByQuantityAvailableDesc(String foodType);
}
