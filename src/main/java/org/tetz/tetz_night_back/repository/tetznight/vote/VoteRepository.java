package org.tetz.tetz_night_back.repository.tetznight.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tetz.tetz_night_back.entity.tetznight.vote.Vote;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByUser(String user);
    long countByVoteType(Vote.VoteType voteType);
}