package org.tetz.tetz_night_back.service.tetznight.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tetz.tetz_night_back.entity.tetznight.vote.Vote;
import org.tetz.tetz_night_back.repository.tetznight.vote.VoteRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;

    public Map<String, Long> getVoteCounts() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("attend", voteRepository.countByVoteType(Vote.VoteType.참여));
        counts.put("notAttend", voteRepository.countByVoteType(Vote.VoteType.불참));
        return counts;
    }

    public Vote createOrUpdateVote(String user, Vote.VoteType voteType) {
        // 사용자의 기존 투표 조회
        Optional<Vote> existingVote = voteRepository.findByUser(user);

        if (existingVote.isPresent()) {
            // 기존 투표가 있는 경우 수정
            Vote vote = existingVote.get();
            vote.setVoteType(voteType);
            return voteRepository.save(vote);
        } else {
            // 새로운 투표 생성
            Vote vote = new Vote();
            vote.setUser(user);
            vote.setVoteType(voteType);
            return voteRepository.save(vote);
        }
    }
}
