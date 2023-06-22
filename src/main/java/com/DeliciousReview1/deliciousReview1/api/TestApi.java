package com.DeliciousReview1.deliciousReview1.api;

import com.DeliciousReview1.deliciousReview1.model.TestEntity;
import com.DeliciousReview1.deliciousReview1.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestApi {
    private final TestService testService;

    @GetMapping("/test/api")
    public ResponseEntity<TestEntity> createEn() {
        TestEntity entity = testService.create("ju", 12);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
}
