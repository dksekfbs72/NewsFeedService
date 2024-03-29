package com.newsfeedservice.NewsFeed.domain.dto;

import com.newsfeedservice.NewsFeed.domain.entity.Activity;
import com.newsfeedservice.NewsFeed.domain.type.FeedType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class FeedDto {
    private FeedType type;
    private String title;
    private String userName;
    private String to;
    private Long postId;
    private Long commentId;
    private LocalDateTime createAt;

    private static FeedDto toDto(Activity activity) {
        return FeedDto.builder()
                .type(activity.getFeedType())
                .title(activity.getTitle())
                .userName(activity.getUserName())
                .to(activity.getTo())
                .postId(activity.getPostId())
                .commentId(activity.getCommentId())
                .createAt(activity.getCreateAt())
                .build();
    }

    public static Page<FeedDto> toPage(Page<Activity> activityPage) {
        List<FeedDto> feedDtoList = activityPage.getContent().stream()
                .map(FeedDto::toDto)
                .toList();

        return new PageImpl<>(feedDtoList, activityPage.getPageable(), activityPage.getTotalElements());
    }
}
