package com.ai.SpringRAG.service;

import org.springframework.stereotype.Service;

@Service
public class RagService {

    private final RetrievalService retrievalService;
    private final OpenAIClientService openAIClientService;

    public RagService(RetrievalService retrievalService,
                      OpenAIClientService openAIClientService) {
        this.retrievalService = retrievalService;
        this.openAIClientService = openAIClientService;
    }

    public String answerQuestion(String query) {
        //Retrieve
        String context = retrievalService.retrieveContext(query);
        //OpenAIcall
        return openAIClientService.generateAnswer(query, context);
    }
}
