package com.ai.SpringRAG.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrievalService {
    //in-memory list (can modify it to file or db)
    private final List<String> knowledgeBase = List.of(
            "Java is a popular programming language. Java is a high-level, object-oriented, and multi-platform programming language used to build a wide variety of applications, from smartphone apps and enterprise software to cloud services and big data engines",
            "Spring Boot is an open-source Java framework used for programming standalone, production-grade Spring-based applications with a bundle of libraries that make project startup and management easier.",
            "RAG stands for Retrieval-Augmented Generation, a technique that improves AI responses by having large language models (LLMs) retrieve external information before generating an answer. It can also refer to a Red, Amber, Green status system for project management, or a general term for ragged clothing or pieces of cloth"
    );

    public String retrieveContext(String query) {
        return knowledgeBase.stream()
                .filter(text -> text.toLowerCase().contains(query.toLowerCase()))
                .findFirst()
                .orElse("Sorry, no information found in the knowledge base.");
    }
}
