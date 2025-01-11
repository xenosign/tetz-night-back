package org.tetz.tetz_night_back.service.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tetz.tetz_night_back.entity.vote.Vote;
import org.tetz.tetz_night_back.repository.VoteRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;

    public Map<String, Long> getVoteCounts() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("참여", voteRepository.countByVoteType(Vote.VoteType.참여));
        counts.put("불참", voteRepository.countByVoteType(Vote.VoteType.불참));
        return counts;
    }
}
