package com.example.wrong.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.time.LocalDate;
@Entity
@Table(name = "wrong_questions")
public @Data class WrongQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String link;

    @NotBlank
    private String reason;

    private String category;

    private LocalDate dateAnswered = LocalDate.now();

    // Getters e Setters

}
