package com.example.demo1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class CalculatorController {

    private final Calculator calculator;
    private final MemberService memberService;

    @PostMapping("/")
    public ResponseEntity<String> saveMember() {
        memberService.save();
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/sum")
    public ResponseEntity<String> sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        int result = calculator.sum(a, b);
        return ResponseEntity.ok(String.valueOf(result));
    }
}