package org.tetz.tetz_night_back.entity.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequest {
    private String content;
    private String user;  // uuid 값을 받을 필드 추가
}

