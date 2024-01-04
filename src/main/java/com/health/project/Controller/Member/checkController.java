package com.health.project.Controller.Member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class checkController {
    @PostMapping
    public ResponseEntity<String> Check(){
        return ResponseEntity.ok().body("토근 체크완료");
    }
}
