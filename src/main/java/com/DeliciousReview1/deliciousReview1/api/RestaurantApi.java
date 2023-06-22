package com.DeliciousReview1.deliciousReview1.api;

import com.DeliciousReview1.deliciousReview1.api.request.CreateAndEditRestaurantRequest;
import com.DeliciousReview1.deliciousReview1.model.RestaurantEntity;
import com.DeliciousReview1.deliciousReview1.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestaurantApi {
    private final RestaurantService restaurantService;
    //GetMaping("/restaurants)

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "this is getAll RES";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(@PathVariable Long restaurantId ) {
        return "this is res " + restaurantId;
    }

    @PostMapping("/restaurant")
    public RestaurantEntity createRestaurant(@RequestBody CreateAndEditRestaurantRequest request) {
        return restaurantService.createdRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(@PathVariable Long restaurantId, @RequestBody CreateAndEditRestaurantRequest request) {
        restaurantService.editRestaurant(restaurantId, request);

    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId){
        restaurantService.deleteRestaurant(restaurantId);

    }
}
