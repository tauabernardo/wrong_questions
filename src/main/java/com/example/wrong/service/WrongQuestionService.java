package com.example.wrong.service;

import com.example.wrong.model.WrongQuestion;
import com.example.wrong.repository.WrongQuestionRepository;

import java.util.List;

public class WrongQuestionService {
    private final WrongQuestionRepository repository;

    public WrongQuestionService(WrongQuestionRepository repository) {
        this.repository = repository;
    }

    public WrongQuestion save(WrongQuestion question) {
        return repository.save(question);
    }

    public List<WrongQuestion> findAll() {
        return repository.findAll();
    }
}
