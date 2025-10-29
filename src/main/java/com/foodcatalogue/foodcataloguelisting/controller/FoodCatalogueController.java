package com.foodcatalogue.foodcataloguelisting.controller;

import com.foodcatalogue.foodcataloguelisting.dto.FoodCataloguePage;
import com.foodcatalogue.foodcataloguelisting.dto.FoodItemDTO;
import com.foodcatalogue.foodcataloguelisting.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("foodCatalogue")
public class FoodCatalogueController {
    @Autowired
    private FoodCatalogueService foc;
    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody
    FoodItemDTO foodItemDTO) {
        FoodItemDTO foodItemSaved = foc.addFoodItem(foodItemDTO);
        return  new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchMenuByRestaurant/{id}")
    public ResponseEntity<FoodCataloguePage> fetchMenuByRestaurant(@PathVariable("id") Integer id) {
        FoodCataloguePage foodCataloguePage = foc.fetchMenu(id);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }
}
