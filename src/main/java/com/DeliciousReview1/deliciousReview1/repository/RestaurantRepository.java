package com.DeliciousReview1.deliciousReview1.repository;

import com.DeliciousReview1.deliciousReview1.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
