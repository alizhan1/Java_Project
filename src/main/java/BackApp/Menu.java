package BackApp;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class Menu {
    private String cuisineType;
    private ArrayList<Food> foods;
    private String restaurantName;

    public Menu(String restaurantName, String cuisineType, ArrayList<Food> foods) {
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.foods = foods;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void removeItem(Food food) {
        for(int i = 0; i < foods.size(); i++) {
            if (food.getName() == foods.get(i).getName()) {
                foods.remove(i);
                return;
            }
        }
    }

    public void addItem(Food food) {
        foods.add(food);
    }

    public String menuInAscending() {
        for(int i = 0; i < foods.size(); i++){
            for(int j = i + 1; j < foods.size(); j++){
                Integer tempI = foods.get(i).getPrice();
                Integer tempJ = foods.get(j).getPrice();

                if(tempI > tempJ) {
                    Collections.swap(foods, i, j);
                }
            }
        }
        return new Gson().toJson(foods);
    }

    public String menuInDescending() {
        for(int i = 0; i < foods.size(); i++){
            for(int j = i + 1; j < foods.size(); j++){
                Integer tempI = foods.get(i).getPrice();
                Integer tempJ = foods.get(j).getPrice();

                if(tempI < tempJ) {
                    Collections.swap(foods,i, j);
                }
            }
        }
        return new Gson().toJson(foods);
    }
}
