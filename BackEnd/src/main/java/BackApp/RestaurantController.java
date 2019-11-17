package BackApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RestaurantController {

    Restaurant myRestaurant = new Restaurant();

    @RequestMapping(value = "/getRestaurantName", method=GET)
    public String getRestaurantName() {
        return myRestaurant.getRestaurantName();
    }
}
