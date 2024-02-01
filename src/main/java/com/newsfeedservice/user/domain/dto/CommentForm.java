package com.newsfeedservice.user.domain.dto;

import com.newsfeedservice.user.domain.entity.Comment;
import com.newsfeedservice.user.domain.entity.Post;
import com.newsfeedservice.user.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentForm {
    private String description;

    public Comment toEntity(User user, Post post) {
        return Comment.builder()
                .post(post)
                .user(user)
                .text(this.description)
                .build();
    }
}
