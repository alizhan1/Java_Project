package BackApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RestaurantController {

    private static final List<Restaurant> ALL_RESTAURANTS = Restaurant.getAll();
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

    public static void main(String[] args) {
        for (int i = 0; i < ALL_RESTAURANTS.size(); i++) {
            System.out.println(ALL_RESTAURANTS.get(i).neighbourhood);
        }
    }
}
