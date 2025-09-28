package com.example.wrong.service;

import com.example.wrong.model.WrongQuestion;
import com.example.wrong.repository.WrongQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WrongQuestionService {

    private final WrongQuestionRepository repository;

    public WrongQuestionService(WrongQuestionRepository repository) {
        this.repository = repository;
    }

    // Criar / salvar
    public WrongQuestion save(WrongQuestion question) {
        return repository.save(question);
    }

    // Listar todas
    public List<WrongQuestion> findAll() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<WrongQuestion> findById(Long id) {
        return repository.findById(id);
    }

    // Atualizar
    public Optional<WrongQuestion> update(Long id, WrongQuestion updated) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setLink(updated.getLink());
            existing.setReason(updated.getReason());
            existing.setCategory(updated.getCategory());
            existing.setDateAnswered(updated.getDateAnswered());
            return repository.save(existing);
        });
    }

    // Deletar
    public boolean delete(Long id) {
        return repository.findById(id).map(existing -> {
            repository.delete(existing);
            return true;
        }).orElse(false);
    }
}
