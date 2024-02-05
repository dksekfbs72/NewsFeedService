package com.newsfeedservice.NewsFeed.controller;

import com.newsfeedservice.NewsFeed.domain.dto.ActivityForm;
import com.newsfeedservice.NewsFeed.domain.dto.FeedDto;
import com.newsfeedservice.NewsFeed.service.NewsFeedService;
import com.newsfeedservice.global.dto.WebResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class NewsFeedController {

    private final NewsFeedService newsFeedService;

    @GetMapping
    public WebResponseData<Page<FeedDto>> getMyFeed(
            @RequestHeader("Authorization") String token,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return WebResponseData.ok(newsFeedService.getMyFeed(token, page, size));
    }

    @PostMapping
    public WebResponseData<String> toBeActivity(
            @RequestBody ActivityForm activityForm
    ) {
        return WebResponseData.ok(newsFeedService.toBeActivity(activityForm));
    }
}
