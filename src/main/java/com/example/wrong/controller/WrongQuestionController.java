package com.example.wrong.controller;

import com.example.wrong.model.WrongQuestion;
import com.example.wrong.service.WrongQuestionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class WrongQuestionController {

    private final WrongQuestionService service;

    public WrongQuestionController(WrongQuestionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WrongQuestion> create(@Valid @RequestBody WrongQuestion question) {
        return ResponseEntity.ok(service.save(question));
    }

    @GetMapping
    public ResponseEntity<List<WrongQuestion>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
