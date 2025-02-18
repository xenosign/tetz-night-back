package org.tetz.tetz_night_back.service.tetznight.post;

import org.tetz.tetz_night_back.dto.tetznight.post.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts(String currentUser);
    PostDto createPost(String content, String currentUser);
    void toggleLike(Long postId, String currentUser);
}
