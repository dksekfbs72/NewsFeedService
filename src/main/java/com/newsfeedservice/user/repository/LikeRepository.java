package com.newsfeedservice.user.repository;

import com.newsfeedservice.user.domain.entity.LikeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeTable, Long> {
}
