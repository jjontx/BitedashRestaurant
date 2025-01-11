package com.bitedash.BitedashRestaurant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bitedash.BitedashRestaurant.dto.RestaurantDTO;
import com.bitedash.BitedashRestaurant.entity.Restaurant;

@Mapper
public interface RestaurantMapper {
	
	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	
	Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
