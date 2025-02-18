package org.tetz.tetz_night_back.repository.tetznight.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tetz.tetz_night_back.entity.tetznight.post.PostLike;

import java.util.Optional;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByPostIdAndUser(Long postId, String user);
}
