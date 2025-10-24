package com.ai.SpringRAG.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrievalService {
    //in-memory list (can modify it to file or db)
    private final List<String> knowledgeBase = List.of(
            "Java is a popular programming language.",
            "Spring Boot helps to build microservices quickly.",
            "RAG stands for Retrieval-Augmented Generation."
    );

    public String retrieveContext(String query) {
        return knowledgeBase.stream()
                .filter(text -> text.toLowerCase().contains(query.toLowerCase()))
                .findFirst()
                .orElse("Sorry, no information found in the knowledge base.");
    }
}
