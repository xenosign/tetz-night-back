package org.tetz.tetz_night_back.service.tetznight.vote;

import org.springframework.stereotype.Service;
import org.tetz.tetz_night_back.entity.tetznight.vote.Vote;

import java.util.Map;

@Service
public interface VoteService {
    Map<String, Long> getVoteCounts();
    Vote createOrUpdateVote(String user, Vote.VoteType voteType);
}
