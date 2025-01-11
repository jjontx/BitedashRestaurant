package com.bitedash.BitedashRestaurant.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import com.bitedash.BitedashRestaurant.dto.RestaurantDTO;
import com.bitedash.BitedashRestaurant.entity.Restaurant;
import com.bitedash.BitedashRestaurant.mapper.RestaurantMapper;
import com.bitedash.BitedashRestaurant.repo.RestaurantRepo;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service // creates a bean in spring container
public class RestaurantService {
	
	@Autowired
	RestaurantRepo restaurantRepo;

	public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
        		.collect(Collectors.toList());
        return restaurantDTOList;
    }

	
	public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant savedRestaurant =  restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
    }


	 public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
	        Optional<Restaurant> restaurant =  restaurantRepo.findById(id);
	        if(restaurant.isPresent()){
	            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
	        }
	        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    }

}
