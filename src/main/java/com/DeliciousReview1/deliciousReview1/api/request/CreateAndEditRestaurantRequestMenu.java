package com.DeliciousReview1.deliciousReview1.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndEditRestaurantRequestMenu {
    private String name;
    private Integer price;
}
