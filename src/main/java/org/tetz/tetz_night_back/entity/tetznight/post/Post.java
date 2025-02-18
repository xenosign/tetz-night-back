package org.tetz.tetz_night_back.entity.tetznight.post;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String content;

    @Column(nullable = false, length = 20)
    private String user;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<PostLike> likes = new HashSet<>();
}
