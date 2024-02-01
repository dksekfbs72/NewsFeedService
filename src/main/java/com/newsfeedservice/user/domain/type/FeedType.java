package com.newsfeedservice.user.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FeedType {
    POST,
    COMMENT,
    FOLLOW,
    LIKE
}
