package BackApp;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Restaurant implements Service {

    public String name;
    public CuisineType cuisineType;
    public Chief chief;
    public Menu menu;
    public List<Table> tables;
    public List<Review> reviews;
    public List<Waiter> waiters;
    public Location location;

    public Restaurant(String name, CuisineType cuisineType, Chief chief, Menu menu, List<Table> tables, List<Review> reviews, List<Waiter> waiters, Location location) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.location = location;
        this.reviews =  reviews;
        this.chief = chief;
        this.menu = menu;
        this.tables = tables;
        this.waiters = waiters;
    }

    @Override
    public void orderFood(String foodName) {
        List<Food> foods = menu.getFoods();
        for (Food food : foods) {
            if (food.getName() == foodName) {
                try {
                    chief.update(food);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public Integer availableTables() {
        Integer availableTables = 0;
        for (Table table : tables) {
            if (!table.isOccupied()) {
                availableTables++;
            }
        }
        return availableTables;
    }

    @Override
    public String getRestaurantName() {
        return this.name;
    }

    @Override
    public void bookTable(Integer numberOfPeople) {
        for (Table table : tables) {
            if (!table.isOccupied() && (table.getCapacity() >= numberOfPeople)) {
                table.occupy();
                break;
            }
        }
        System.out.println("Table has been booked");
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Waiter getWaiter() {
        return waiters.get(0);
    }

}
