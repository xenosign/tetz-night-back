package org.tetz.tetz_night_back.service.tetznight.post;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tetz.tetz_night_back.dto.tetznight.post.PostDto;
import org.tetz.tetz_night_back.entity.tetznight.post.Post;
import org.tetz.tetz_night_back.entity.tetznight.post.PostLike;
import org.tetz.tetz_night_back.repository.tetznight.post.PostLikeRepository;
import org.tetz.tetz_night_back.repository.tetznight.post.PostRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;

    public List<PostDto> getAllPosts(String currentUser) {
        List<Object[]> results = postRepository.findAllPostsWithLikeInfo(currentUser);

        return results.stream()
                .map(result -> new PostDto(
                        ((Long) result[0]).longValue(), // id
                        (String) result[1],                   // content
                        (String) result[2],                   // user
                        (Timestamp) result[3],                // createdAt
                        ((Long) result[4]).longValue(), // likeCount
                        ((Long) result[5]).intValue()   // isLiked
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public PostDto createPost(String content, String user) {  // 메서드 시그니처 변경
        Post post = new Post();
        post.setContent(content);
        post.setUser(user);  // Request에서 받은 uuid 사용
        post.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        Post savedPost = postRepository.save(post);

        return new PostDto(
                savedPost.getId(),
                savedPost.getContent(),
                savedPost.getUser(),
                savedPost.getCreatedAt(),
                0L,
                0
        );
    }

    @Transactional
    public void toggleLike(Long postId, String currentUser) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        Optional<PostLike> existingLike = postLikeRepository.findByPostIdAndUser(postId, currentUser);

        if (existingLike.isPresent()) {
            postLikeRepository.delete(existingLike.get());  // 직접 삭제
        } else {
            PostLike newLike = new PostLike(post, currentUser);
            postLikeRepository.save(newLike);  // 직접 저장
        }
    }
}
