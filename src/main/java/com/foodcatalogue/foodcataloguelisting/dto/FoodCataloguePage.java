package com.foodcatalogue.foodcataloguelisting.dto;
import com.foodcatalogue.foodcataloguelisting.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
    List<FoodItem> foodItemList;
    Restaurant restaurant;
}
