package org.tetz.tetz_night_back.service.post;

import org.tetz.tetz_night_back.dto.post.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts(String currentUser);
    PostDto createPost(String content, String currentUser);
    void toggleLike(Long postId, String currentUser);
}
