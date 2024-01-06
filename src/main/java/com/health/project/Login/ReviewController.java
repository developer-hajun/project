package com.health.project.Login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @PostMapping("/sos")
    public ResponseEntity<String> sos(){
        return ResponseEntity.ok().body("SoS요청이 완료되었습니다");
    }
}
