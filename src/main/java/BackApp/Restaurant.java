package BackApp;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class Restaurant implements Service {

    public String name, cuisineType, neighbourhood;
    double averagegRating;

    public Restaurant(String name, String cuisineTpe, String neighbourhood, double avgRating) {
        this.name = name;
        this.cuisineType = cuisineTpe;
        this.neighbourhood = neighbourhood;
        this.averagegRating =  avgRating;
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
        Gson gson = new Gson();
        JsonReader reader = getJSONReader();
        Map<String, ?> jsonDict = gson.fromJson(reader, Object.class);
        ArrayList<?> json = (ArrayList<?>) jsonDict.get("restaurants");

        ArrayList<Restaurant> restos = new ArrayList<>();

        for (int i = 0; i < json.size(); i++) {
            Map<String, ?> restaurantJSON = (Map<String, ?>) json.get(i);
            ArrayList<?> reviews = (ArrayList<?>) restaurantJSON.get("reviews");

            double totalRating = 0;
            for (int j = 0; j < reviews.size(); j++) {
                Map<String, ?> reviewDict = (Map<String, ?>) reviews.get(j);
                Object value = reviewDict.get("rating");
                totalRating += (double) value;
            }

            double rating = totalRating/reviews.size();
            String name = (String) restaurantJSON.get("name");
            String cuisineType = (String) restaurantJSON.get("cuisine_type");
            String neighbourhood = (String) restaurantJSON.get("neighborhood");

            Restaurant resto = new Restaurant(name, cuisineType, neighbourhood, rating);
            restos.add(resto);
            }

        return restos;
    }

    public static JsonReader getJSONReader() {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("src/main/Resources/Restaurant.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }
}
