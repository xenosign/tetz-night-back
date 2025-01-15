package org.tetz.tetz_night_back.entity.post;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_likes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(nullable = false, length = 20)
    private String user;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public PostLike(Post post, String user) {
        this.post = post;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
}
