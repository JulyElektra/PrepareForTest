package com.example.elekt.preparefortest.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by elekt on 07.07.2017.
 */

public class Task {
    private Long id;
    private String question;
    private Map<String, Boolean> possibleAnswers = new HashMap<>();
    private String explanation;
    private User creator;
    private Boolean isApproved;
    private String codeChunk;

    public Task(Long id, String question, Map<String, Boolean> possibleAnswers, String explanation, User creator, Boolean isApproved, String codeChunk) {
        this.id = id;
        this.question = question;
        this.explanation = explanation;
        this.creator = creator;
        this.isApproved = isApproved;
        if (possibleAnswers == null) {
            this.possibleAnswers = new HashMap<>();
        } else {
            this.possibleAnswers = possibleAnswers;
        }
        if (codeChunk != null) {
            this.codeChunk = codeChunk;
        } else {
            this.codeChunk = "";
        }
    }

    public Long getId() {
        return id;
    }

    public User getCreator() {
        return creator;
    }

    public Boolean getApproved() {
        return isApproved;
    }
//    public Task(String question, Map<String, Boolean> possibleAnswers, String explanation) {
//        this.question = question;
//        this.possibleAnswers = possibleAnswers;
//        this.explanation = explanation;
//    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, Boolean> getPossibleAnswers() {
        if (possibleAnswers == null) {
            return new HashMap<>();
        }
        return possibleAnswers;
    }

    public void addPossibleAnswers(String possibleAnswer, Boolean isCorrect) {
        possibleAnswers.put(possibleAnswer, isCorrect);
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getCodeChunk() {
        return codeChunk;
    }
}
