package com.newsfeedservice.NewsFeed.controller;

import com.newsfeedservice.NewsFeed.domain.dto.FeedDto;
import com.newsfeedservice.NewsFeed.service.NewsFeedService;
import com.newsfeedservice.global.dto.WebResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class NewsFeedController {

    private final NewsFeedService newsFeedService;

    @GetMapping("/feed")
    public WebResponseData<Page<FeedDto>> getMyFeed(
            Authentication auth,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return WebResponseData.ok(newsFeedService.getMyFeed(auth, page, size));
    }
}
