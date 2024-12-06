package de.nku.springaiintro.services;

import de.nku.springaiintro.models.*;

public interface OpenAIService {
    String getAnswer(String question);
    Answer getAnswer(Question question);
    GetCapitalResponse getCapital(GetCapitalRequest request);
    GetCapitalResponseWithInfo getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}
