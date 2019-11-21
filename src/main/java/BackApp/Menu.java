package BackApp;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class Menu {
    private CuisineType cuisineType;
    public CuisineType getCuisineType() {
        return cuisineType;
    }

    private ArrayList<Food> foods;
    public ArrayList<Food> getFoods() {
        return foods;
    }

    private Restaurant restaurant;
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Menu(Restaurant _restaurant) {
        this.restaurant = _restaurant;
        this.getMenuFor(_restaurant);
        this.cuisineType = _restaurant.cuisineType;
    }

    public void getMenuFor(Restaurant restaurant) {
        //Get food items served at this restaurant from JSON and put them into foods array

        for(int i = 0; i < 10; i++) {
            this.foods.add(new Food("Test chicken", "Some scrumptious chicken like gramma's", 15));
        }
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
