package com.DeliciousReview1.deliciousReview1.repository;

import com.DeliciousReview1.deliciousReview1.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom{
    public List<TestEntity> findAllByName(String name);
}
