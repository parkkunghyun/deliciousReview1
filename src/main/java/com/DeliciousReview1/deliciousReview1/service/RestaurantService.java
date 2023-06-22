package com.DeliciousReview1.deliciousReview1.service;

import com.DeliciousReview1.deliciousReview1.api.request.CreateAndEditRestaurantRequest;
import com.DeliciousReview1.deliciousReview1.model.MenuEntity;
import com.DeliciousReview1.deliciousReview1.model.RestaurantEntity;
import com.DeliciousReview1.deliciousReview1.repository.MenuRepository;
import com.DeliciousReview1.deliciousReview1.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public RestaurantEntity createdRestaurant(CreateAndEditRestaurantRequest request) {
        // 이름과 주소 메뉴가 필수!
        RestaurantEntity restaurant = RestaurantEntity
                .builder()
                .name(request.getName())
                .address(request.getAddress())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        restaurantRepository.save(restaurant);

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build();
            menuRepository.save(menuEntity);
        });

        return restaurant;
    }

    @Transactional
    public void editRestaurant(Long restaurantId, CreateAndEditRestaurantRequest request) {
       RestaurantEntity restaurant =  restaurantRepository.findById(restaurantId).orElseThrow(()-> new RuntimeException("없는 레스토랑!"));
        restaurant.changeNameAndAddress(request.getName(), request.getAddress());
        restaurantRepository.save(restaurant);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurantId)
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build();
            menuRepository.save(menuEntity);
        });
    }

    @Transactional
    public void deleteRestaurant(Long restaurantId) {
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        restaurantRepository.delete(restaurant);

        List<MenuEntity> menuEntityLit = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menuEntityLit);
    }
}
