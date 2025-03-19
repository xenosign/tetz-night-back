package org.tetz.tetz_night_back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String vote() {
        return "Hello, world!";
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("여기는 Tetz 백엔드 서버입니다");
    }
}
