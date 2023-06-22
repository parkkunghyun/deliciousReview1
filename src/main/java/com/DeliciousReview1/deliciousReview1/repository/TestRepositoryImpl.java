package com.DeliciousReview1.deliciousReview1.repository;

import com.DeliciousReview1.deliciousReview1.model.QTestEntity;
import com.DeliciousReview1.deliciousReview1.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepositoryImpl implements TestRepositoryCustom {
    // impl은 구현 클래스에 붙여주는 접미사!
    private final JPAQueryFactory queryFactory;

    @Override
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory.selectFrom(QTestEntity.testEntity)
                .fetch();

    }
}
