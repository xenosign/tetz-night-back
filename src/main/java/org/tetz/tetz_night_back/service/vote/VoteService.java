package org.tetz.tetz_night_back.service.vote;

import org.springframework.stereotype.Service;
import org.tetz.tetz_night_back.entity.vote.Vote;

import java.util.List;
import java.util.Map;

@Service
public interface VoteService {
    Map<String, Long> getVoteCounts();
    Vote createVote(String user, Vote.VoteType voteType);
}
