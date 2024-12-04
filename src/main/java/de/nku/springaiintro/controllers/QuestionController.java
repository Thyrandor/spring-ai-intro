package de.nku.springaiintro.controllers;

import de.nku.springaiintro.models.Answer;
import de.nku.springaiintro.models.Question;
import de.nku.springaiintro.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping
    public Answer askQuestion(Question question) {
        return openAIService.getAnswer(question);
    }
}