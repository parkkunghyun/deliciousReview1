package com.DeliciousReview1.deliciousReview1.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndEditRestaurantRequest {
    // nae address
    private String name;
    private  String address;
    private List<CreateAndEditRestaurantRequestMenu> menus;
}
