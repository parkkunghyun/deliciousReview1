package com.DeliciousReview1.deliciousReview1.api;

import com.DeliciousReview1.deliciousReview1.model.TestEntity;
import com.DeliciousReview1.deliciousReview1.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestQueryApi {
    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJpa() {
        return testService.findByNameJPA("ju");
    }

    @GetMapping("/test/query/querydsl")
    public List<TestEntity> querydsl() {
        return testService.findAllByNameQuerydsl("ju");
    }
}
