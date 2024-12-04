package de.nku.springaiintro.services;

import de.nku.springaiintro.models.Answer;
import de.nku.springaiintro.models.Question;

public interface OpenAIService {
    String getAnswer(String question);
    Answer getAnswer(Question question);

}
