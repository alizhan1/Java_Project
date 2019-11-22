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

    private static List<Restaurant> ALL_RESTAURANTS = getAll();
    private static Restaurant selectedRestaurant = ALL_RESTAURANTS.get(0);
    public static Gson gson = new Gson();
    public List<Food> orders = new ArrayList<>();


    @RequestMapping(value = "/selectRestaurant", method=POST)
    public String selectRestaurant(@RequestParam(value="name", defaultValue="Emily") String name) {
        for (Restaurant r : ALL_RESTAURANTS) {
            if (r.getRestaurantName() == name) {
                selectedRestaurant = r;
                return "SUCCESS!";
            }
        }
        return "NOT SELECTED TRY AGAIN!";
    }

    @RequestMapping(value = "/", method=GET)
    public String welcomePage() {
        return "Welcome, To Restaurant Service Provider Backend!!";
    }

    @RequestMapping(value = "/getRestaurantName", method=GET)
    public String getRestaurantName() {
        return selectedRestaurant.getRestaurantName();
    }

    @RequestMapping(value = "/orderFood", method=POST)
    public String orderFood(@RequestParam(value="name", defaultValue="chicken") String name) {
        selectedRestaurant.orderFood(name);
        for (Food order : selectedRestaurant.getMenu().getFoods()) {
            if (order.getName() == name) {
                orders.add(new Food(name, "###", order.getPrice()));
            }
        }
        orders.add(new Food(name, "###", 666));
        return "SUCCESS!";
    }

    @RequestMapping(value = "/bookTable", method=POST)
    public String bookTable(@RequestParam(value="numberOfPeople", defaultValue="4") String numberOfPeople) {
        selectedRestaurant.bookTable(Integer.parseInt(numberOfPeople));
        return "SUCCESS!";
    }

    @RequestMapping(value = "/getBill", method=GET)
    public String getBill() {
        return gson.toJson(new Bill(1, selectedRestaurant.getWaiter(), orders));
    }

    @RequestMapping(value = "/availableTables", method=GET)
    public Integer availableTables() {
        return selectedRestaurant.availableTables();
    }

    @RequestMapping(value = "/getMenu", method=GET)
    public String getMenu() {
        return gson.toJson(selectedRestaurant.getMenu());
    }

    @RequestMapping(value = "/getReviews", method=GET)
    public String getReview() {
        return gson.toJson(selectedRestaurant.getReviews());
    }

    @RequestMapping(value = "/restaurants", method=GET)
    public String getAllRestaurants() {
        return gson.toJson(ALL_RESTAURANTS);
    }

    public static List<Restaurant> getAll() {
        Gson gson = new Gson();
        JsonReader reader = getJSONReader();
        Map<String, ?> jsonDict = gson.fromJson(reader, Object.class);
        ArrayList<?> json = (ArrayList<?>) jsonDict.get("restaurants");

        ArrayList<Restaurant> restos = new ArrayList<>();

        for (int i = 0; i < json.size(); i++) {
            Map<String, ?> restaurantJSON = (Map<String, ?>) json.get(i);

            String restaurantName = (String) restaurantJSON.get("name");

            Map<String, ?> cuisineTypeJSON = (Map<String, ?>) restaurantJSON.get("cuisine_type");
            String cuisineTypeName = (String) cuisineTypeJSON.get("name");
            String cuisineTypeCountry = (String) cuisineTypeJSON.get("country_of_origin");
            String cuisineTypeDescription = (String) cuisineTypeJSON.get("description");
            CuisineType cuisineType = new CuisineType(cuisineTypeName, cuisineTypeCountry, cuisineTypeDescription);

            Chief chief = new Chief();

            Map<String, ?> menuJSON = (Map<String, ?>) restaurantJSON.get("menu");
            ArrayList<Map<String, ?>> foodsJSON = (ArrayList<Map<String, ?>>) menuJSON.get("foods");
            ArrayList<Food> foods = new ArrayList<>();
            for(int j = 0; j < foodsJSON.size(); j++) {
                String name = (String) foodsJSON.get(j).get("name");
                String description = (String) foodsJSON.get(j).get("description");
                double price = (double) foodsJSON.get(j).get("price");

                Food food = new Food(name, description, price);
                foods.add(food);
            }

            Menu menu = new Menu(restaurantName, cuisineType.getName(), foods);

            ArrayList<?> tablesJSON = (ArrayList<?>) restaurantJSON.get("tables");
            ArrayList<Table> tables = new ArrayList<>();
            for (int j = 0; j < tablesJSON.size(); j++) {
                Map<String, ?> tempTable = (Map<String, ?>) tablesJSON.get(j);
                boolean isOccupied = (boolean) tempTable.get("is_occupied");
                double capacity = (double) tempTable.get("capacity");

                Table table = new Table(capacity, isOccupied);
                tables.add(table);
            }

            ArrayList<?> reviewsJSON = (ArrayList<?>) restaurantJSON.get("reviews");
            ArrayList<Review> reviews = new ArrayList<>();
            for(int j = 0; j < reviewsJSON.size(); j++) {
                Map<String, ?> tempReview = (Map<String, ?>) reviewsJSON.get(j);
                String name = (String) tempReview.get("name");
                String date = (String) tempReview.get("date");
                double rating = (double) tempReview.get("rating");
                String comments = (String) tempReview.get("comments");

                Review review = new Review(name, date, rating, comments);
                reviews.add(review);
            }

            ArrayList<Waiter> waiters = new ArrayList<>();

            Map<String, ?> locationJSON = (Map<String, ?>) restaurantJSON.get("location");
            String locNeighbourhood = (String) locationJSON.get("neighborhood");
            String address = (String) locationJSON.get("address");
            double latitude = (double) locationJSON.get("lat");
            double longitude = (double) locationJSON.get("lng");

            Location location = new Location(locNeighbourhood, address, latitude, longitude);

            Restaurant restaurantToAppend = new Restaurant(restaurantName, cuisineType, chief, menu, tables, reviews, waiters, location);
            restos.add(restaurantToAppend);
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
