package com.example.wrong.controller;

import com.example.wrong.model.WrongQuestion;
import com.example.wrong.service.WrongQuestionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class WrongQuestionController {

    private final WrongQuestionService service;

    public WrongQuestionController(WrongQuestionService service) {
        this.service = service;
    }

    // Criar questão errada
    @PostMapping
    public ResponseEntity<WrongQuestion> create(@Valid @RequestBody WrongQuestion question) {
        return ResponseEntity.ok(service.save(question));
    }

    // Listar todas as questões
    @GetMapping
    public ResponseEntity<List<WrongQuestion>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Buscar questão por ID
    @GetMapping("/{id}")
    public ResponseEntity<WrongQuestion> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar questão
    @PutMapping("/{id}")
    public ResponseEntity<WrongQuestion> update(@PathVariable Long id, @Valid @RequestBody WrongQuestion updated) {
        return service.update(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar questão
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
