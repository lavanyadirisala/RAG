package com.ai.SpringRAG.controller;

import com.ai.SpringRAG.model.QueryRequest;
import com.ai.SpringRAG.service.RagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RagController {

    @Autowired
    private RagService ragService;

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody QueryRequest request) {
        String response = ragService.answerQuestion(request.getQuery());
        return ResponseEntity.ok(response);
    }
}
