package org.tetz.tetz_night_back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tetz.tetz_night_back.dto.vote.VoteDto;
import org.tetz.tetz_night_back.entity.vote.Vote;
import org.tetz.tetz_night_back.service.vote.VoteService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final VoteService voteService;

    // 투표 결과 조회
    @GetMapping("/vote")
    public Map<String, Long> vote() {
        return voteService.getVoteCounts();
    }

    // 투표 하기
    @PostMapping("/vote")
    public ResponseEntity<?> createVote(@RequestBody VoteDto voteDto) {
        try {
            Vote vote = voteService.createOrUpdateVote(voteDto.getUser(), voteDto.getVoteType());
            return ResponseEntity.ok(VoteDto.from(vote));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("이미 투표한 사용자입니다.");
        }
    }
}
