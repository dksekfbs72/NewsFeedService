package com.newsfeedservice.NewsFeed.domain.dto;

import com.newsfeedservice.NewsFeed.domain.type.FeedType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ActivityForm {
    private Long userId;
    private FeedType feedType;
    private String title;
    private String userName;
    private String to;
    private Long postId;
    private Long commentId;
}
