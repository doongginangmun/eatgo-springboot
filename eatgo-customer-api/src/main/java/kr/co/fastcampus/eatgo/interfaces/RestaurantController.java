package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private RestaurantService restaurantService;



    @GetMapping("/restaurants")
    public List<Restaurant> list(
            @RequestParam("region")String region,
            @RequestParam("category")Long categoryId
    ) {
        List<Restaurant> restaurants =
                restaurantService.getRestaurants(region, categoryId);

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant =restaurantService.getRestaurant(id);
        //기본정보 + 메뉴정보

        return restaurant;
    }
}
