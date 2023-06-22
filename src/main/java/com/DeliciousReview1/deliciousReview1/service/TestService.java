package com.DeliciousReview1.deliciousReview1.service;

import com.DeliciousReview1.deliciousReview1.model.TestEntity;
import com.DeliciousReview1.deliciousReview1.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public TestEntity create(String name, int age) {
        TestEntity entity = new TestEntity(name,age);
        return testRepository.save(entity);
    }

    public List<TestEntity> findByNameJPA(String name) {
        return testRepository.findAllByName(name);
    }

    public List<TestEntity> findAllByNameQuerydsl(String name) {
        return testRepository.findAllByNameByQuerydsl(name);

    }
}
