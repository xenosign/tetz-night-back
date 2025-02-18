package org.tetz.tetz_night_back.repository.tetznight.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tetz.tetz_night_back.entity.tetznight.post.Post;


import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = """
        SELECT 
            p.id as id,
            p.content as content,
            p.user as user,
            p.created_at as createdAt,
            COUNT(DISTINCT pl.id) as likeCount,
            IF(SUM(CASE WHEN pl2.user = :currentUser THEN 1 ELSE 0 END) > 0, 1, 0) as isLiked
        FROM posts p
        LEFT JOIN post_likes pl ON p.id = pl.post_id
        LEFT JOIN post_likes pl2 ON p.id = pl2.post_id AND pl2.user = :currentUser
        GROUP BY p.id, p.content, p.user, p.created_at
        ORDER BY COUNT(DISTINCT pl.id) DESC, p.created_at ASC
        """,
            nativeQuery = true)
    List<Object[]> findAllPostsWithLikeInfo(@Param("currentUser") String currentUser);
}