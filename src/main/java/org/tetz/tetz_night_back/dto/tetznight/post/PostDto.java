package org.tetz.tetz_night_back.dto.tetznight.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PostDto {
    private Long id;
    private String content;
    private String user;
    private Timestamp createdAt;
    private long likeCount;
    private int liked;
}