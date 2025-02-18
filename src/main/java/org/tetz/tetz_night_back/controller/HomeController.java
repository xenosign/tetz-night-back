package org.tetz.tetz_night_back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String vote() {
        return "Hello, world!";
    }
}
