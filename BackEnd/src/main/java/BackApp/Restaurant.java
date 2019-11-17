package BackApp;

import java.util.List;

public class Restaurant implements Service {

    public String name;

    public Restaurant(String name) {
        this.name = name;
    }

    @Override
    public boolean addToCart(String meal) {
        return false;
    }

    @Override
    public Integer availableTables() {
        return null;
    }

    @Override
    public String getRestaurantName() {
        return this.name;
    }

    @Override
    public boolean bookTable(Integer tableId) {
        return false;
    }

    public static List<Restaurant> getAll() {
        return null;
    }
}
