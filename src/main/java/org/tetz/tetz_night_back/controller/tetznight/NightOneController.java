//package org.tetz.tetz_night_back.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.tetz.tetz_night_back.dto.post.PostDto;
//import org.tetz.tetz_night_back.dto.vote.VoteDto;
//import org.tetz.tetz_night_back.entity.post.PostRequest;
//import org.tetz.tetz_night_back.entity.vote.Vote;
//import org.tetz.tetz_night_back.service.post.PostService;
//import org.tetz.tetz_night_back.service.vote.VoteService;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
//@RequestMapping("/")
//public class NightOneController {
//    private final VoteService voteService;
//    private final PostService postService;
//
//    // 투표 결과 조회
//    @GetMapping("/vote")
//    public Map<String, Long> vote() {
//        return voteService.getVoteCounts();
//    }
//
//    // 투표 하기
//    @PostMapping("/vote")
//    public ResponseEntity<?> createVote(@RequestBody VoteDto voteDto) {
//        try {
//            Vote vote = voteService.createOrUpdateVote(voteDto.getUser(), voteDto.getVoteType());
//            return ResponseEntity.ok(VoteDto.from(vote));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("이미 투표한 사용자입니다.");
//        }
//    }
//
//    @GetMapping("/post")
//    public ResponseEntity<List<PostDto>> getAllPosts(
//            @RequestHeader("uuid") String userId) {
//        return ResponseEntity.ok(postService.getAllPosts(userId));
//    }
//
//    @PostMapping("/post")
//    public ResponseEntity<PostDto> createPost(@RequestBody PostRequest request) {
//        PostDto createdPost = postService.createPost(
//                request.getContent(),
//                request.getUser()
//        );
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
//    }
//
//    @PostMapping("/{postId}/like")
//    public ResponseEntity<Void> toggleLike(
//            @PathVariable Long postId,
//            @RequestHeader("uuid") String userId) {
//        postService.toggleLike(postId, userId);
//        return ResponseEntity.ok().build();
//    }
//}
