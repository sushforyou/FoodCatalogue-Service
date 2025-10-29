package com.foodcatalogue.foodcataloguelisting.mapper;

import com.foodcatalogue.foodcataloguelisting.dto.FoodItemDTO;
import com.foodcatalogue.foodcataloguelisting.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapFoodItemDTOTOFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodToFoodItemDTO(FoodItem foodItem);
}
