package de.nku.springaiintro.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAIServiceImplTest {

    @Autowired
    OpenAIService service;

    @Test
    void getAnswer() {
        String answer = service.getAnswer("Erzähl mir einen Ostfriesen-Witz!");
        System.out.println("=======================");
        System.out.println(answer);
        System.out.println("=======================");
    }
}