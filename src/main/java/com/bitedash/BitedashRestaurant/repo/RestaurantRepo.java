package com.bitedash.BitedashRestaurant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bitedash.BitedashRestaurant.entity.Restaurant;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
}
