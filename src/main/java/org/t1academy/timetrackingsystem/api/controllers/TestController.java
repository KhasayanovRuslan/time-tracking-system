package org.t1academy.timetrackingsystem.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.t1academy.timetrackingsystem.services.TestService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @Operation(summary = "Запуск методов для проверки")
    @GetMapping("/time/methods/test")
    public ResponseEntity<Void> test() {
        testService.testTime();
        testService.testAsyncTime();
        return ResponseEntity.ok().build();
    }
}
