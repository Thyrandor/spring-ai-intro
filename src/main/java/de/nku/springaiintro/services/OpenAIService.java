package de.nku.springaiintro.services;

import de.nku.springaiintro.models.Answer;
import de.nku.springaiintro.models.GetCapitalRequest;
import de.nku.springaiintro.models.GetCapitalResponse;
import de.nku.springaiintro.models.Question;

public interface OpenAIService {
    String getAnswer(String question);
    Answer getAnswer(Question question);
    GetCapitalResponse getCapital(GetCapitalRequest request);
    Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}
