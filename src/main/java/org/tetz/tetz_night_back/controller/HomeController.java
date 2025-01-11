package org.tetz.tetz_night_back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tetz.tetz_night_back.service.vote.VoteService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final VoteService voteService;

    @GetMapping("/vote")
    public Map<String, Long> vote() {
        return voteService.getVoteCounts();
    }
}
