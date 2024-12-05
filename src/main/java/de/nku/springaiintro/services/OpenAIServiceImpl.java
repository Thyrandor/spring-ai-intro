package de.nku.springaiintro.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.nku.springaiintro.models.Answer;
import de.nku.springaiintro.models.GetCapitalRequest;
import de.nku.springaiintro.models.Question;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatModel chatModel;

    @Value("classpath:templates/get-capital-prompt.st")
    private Resource getCapitalPrompt;

    @Value("classpath:templates/get-capital-with-info.st")
    private Resource getCapitalWithInfo;

    @Autowired
    private ObjectMapper mapper;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();

        ChatResponse response = chatModel.call(prompt);

        return response.getResult().getOutput().getContent();
    }

    @Override
    public Answer getAnswer(Question question) {
        System.out.println("=== Frage: " + question.question());
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();

        ChatResponse response = chatModel.call(prompt);

        return new Answer(response.getResult().getOutput().getContent());
    }

    @Override
    public Answer getCapital(GetCapitalRequest request) {
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", request.stateOrCountry()));

        ChatResponse response = chatModel.call(prompt);
        System.out.println(response.getResult().getOutput().getContent());

        String responseString;

        try {
            JsonNode node = mapper.readTree(response.getResult().getOutput().getContent());
            responseString = node.get("answer").asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//        return new Answer(response.getResult().getOutput().getContent());
        return new Answer(responseString);
    }

    @Override
    public Answer getCapitalWithInfo(GetCapitalRequest request) {
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalWithInfo);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", request.stateOrCountry()));

        ChatResponse response = chatModel.call(prompt);

        return new Answer(response.getResult().getOutput().getContent());
    }
}
