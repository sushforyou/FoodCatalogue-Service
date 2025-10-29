package com.foodcatalogue.foodcataloguelisting.service;

import com.foodcatalogue.foodcataloguelisting.dto.FoodCataloguePage;
import com.foodcatalogue.foodcataloguelisting.dto.FoodItemDTO;
import com.foodcatalogue.foodcataloguelisting.dto.Restaurant;
import com.foodcatalogue.foodcataloguelisting.entity.FoodItem;
import com.foodcatalogue.foodcataloguelisting.mapper.FoodItemMapper;
import com.foodcatalogue.foodcataloguelisting.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {
    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOTOFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodToFoodItemDTO(foodItem);
    }

    public FoodCataloguePage fetchMenu(Integer id) {
        List<FoodItem> foodItemList = fetchFoodMenu(id);
        Restaurant restaurant  = fetchRestaurantDetails(id);
        createFoodCatalogue(foodItemList,restaurant);
        return new FoodCataloguePage(foodItemList,restaurant);
    }

    private List<FoodItem> fetchFoodMenu(Integer id) {
        return foodItemRepo.findByRestaurantId(id);
    }
    private Restaurant fetchRestaurantDetails(Integer id) {
     return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+id, Restaurant.class);
    }
    private FoodCataloguePage createFoodCatalogue(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }
}
