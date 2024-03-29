package com.newsfeedservice.NewsFeed.domain.entity;

import com.newsfeedservice.NewsFeed.domain.type.FeedType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(name = "create_at_desc", columnList = "create_at DESC"),
        @Index(name = "user_asc", columnList = "user_id")
})
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private FeedType feedType;
    private String title;
    private Long userId;
    private String userName;
    @Column(name = "to_column")
    private String to;
    private Long postId;
    private Long commentId;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createAt;
    @PrePersist
    protected void onCreate() {
        createAt = LocalDateTime.now();
    }
}
