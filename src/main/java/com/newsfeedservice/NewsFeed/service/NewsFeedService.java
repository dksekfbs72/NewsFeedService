package com.newsfeedservice.NewsFeed.service;

import com.newsfeedservice.NewsFeed.domain.dto.FeedDto;
import com.newsfeedservice.NewsFeed.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsFeedService {
    private final ActivityRepository activityRepository;


    public Page<FeedDto> getMyFeed(Authentication auth, int page, int size) {
//        User user = whoIAm(auth);
//        List<User> friends = new ArrayList<>();
//        friends.add(user);
//        Optional<List<Long>> following = followRepository.findUsersByUserId(user.getId());
//        Optional<List<Long>> follower = followRepository.findUserByFollowId(user.getId());
//        following.ifPresent(longs -> friends.addAll(userRepository.findAllById(longs)));
//        follower.ifPresent(longs -> friends.addAll(userRepository.findAllById(longs)));
//        friends.add(user);


//        Page<Activity> activityPage = activityRepository.findAllByUserInOrderByCreateAtDesc(friends, PageRequest.of(page, size));

//        return FeedDto.toPage(activityPage);
        return null;
    }
}
