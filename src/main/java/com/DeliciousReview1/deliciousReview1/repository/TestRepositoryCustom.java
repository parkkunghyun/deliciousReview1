package com.DeliciousReview1.deliciousReview1.repository;

import com.DeliciousReview1.deliciousReview1.model.TestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepositoryCustom {
    public List<TestEntity> findAllByNameByQuerydsl(String name);
}
