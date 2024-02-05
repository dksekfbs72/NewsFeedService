package com.newsfeedservice.NewsFeed.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsfeedservice.NewsFeed.domain.dto.ActivityForm;
import com.newsfeedservice.NewsFeed.domain.dto.FeedDto;
import com.newsfeedservice.NewsFeed.domain.dto.UserDto;
import com.newsfeedservice.NewsFeed.domain.entity.Activity;
import com.newsfeedservice.NewsFeed.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsFeedService {
    private final ActivityRepository activityRepository;
    private final RestTemplate restTemplate;


    public Page<FeedDto> getMyFeed(String token, int page, int size) {
        UserDto user = getUserInfo(token);
        List<Long> friends = getMyFriends(user.getId());

        Page<Activity> activityPage = activityRepository.findAllByUserIdInOrderByCreateAtDesc(friends, PageRequest.of(page, size));

        return FeedDto.toPage(activityPage);
    }

    private UserDto getUserInfo(String token) {
        String url = "http://userService:8080/user/info";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        UserDto userDto;
        try {
            userDto = objectMapper.readValue(response.getBody(), UserDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return userDto;
    }

    private List<Long> getMyFriends(Long userId) {
        String url = "http://activityService:8081/follow?userId="+userId;

        ResponseEntity<List<Long>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public String toBeActivity(ActivityForm activityForm) {
        activityRepository.save(Activity.builder()
                        .userId(activityForm.getUserId())
                        .feedType(activityForm.getFeedType())
                        .title(activityForm.getTitle())
                        .userName(activityForm.getUserName())
                        .to(activityForm.getTo())
                        .postId(activityForm.getPostId())
                        .commentId(activityForm.getCommentId())
                .build());
        return "저장 성공";
    }
}
