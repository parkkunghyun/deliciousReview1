package com.DeliciousReview1.deliciousReview1.repository;

import com.DeliciousReview1.deliciousReview1.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    public List<MenuEntity> findAllByRestaurantId(Long restaurantId);
}
