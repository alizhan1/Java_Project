package BackApp;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RestaurantController {

    private static List<Restaurant> ALL_RESTAURANTS;
    private static Restaurant selectedRestaurant;

    @RequestMapping(value = "/selectRestaurant", method=POST)
    public void selectRestaurant(@RequestParam(value="name", defaultValue="Emily") String name) {
        for (Restaurant r : ALL_RESTAURANTS) {
            if (r.getRestaurantName() == name) {
                selectedRestaurant = r;
            }
        }
    }

    @RequestMapping(value = "/getRestaurantName", method=GET)
    public String getRestaurantName() {
        return selectedRestaurant.getRestaurantName();
    }

    @RequestMapping(value = "/orderFood", method=POST)
    public void orderFood(@RequestParam(value="name", defaultValue="chicken") String name) {
        selectedRestaurant.orderFood(name);
    }

    @RequestMapping(value = "/bookTable", method=POST)
    public void bookTable(@RequestParam(value="numberOfPeople", defaultValue="4") String numberOfPeople) {
        selectedRestaurant.bookTable(Integer.parseInt(numberOfPeople));
    }

    @RequestMapping(value = "/availableTables", method=GET)
    public Integer availableTables() {
        return selectedRestaurant.availableTables();
    }

    @RequestMapping(value = "/getMenu", method=GET)
    public String getMenu() {
        return selectedRestaurant.getMenu();
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

    //        Restaurant resto = new Restaurant(name, cuisineType, neighbourhood, rating);
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
