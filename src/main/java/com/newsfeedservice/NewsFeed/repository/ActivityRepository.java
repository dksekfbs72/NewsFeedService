package com.newsfeedservice.NewsFeed.repository;

import com.newsfeedservice.NewsFeed.domain.entity.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Page<Activity> findAllByUserIdInOrderByCreateAtDesc(List<Long> friends, PageRequest of);
}
