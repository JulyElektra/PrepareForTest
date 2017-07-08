package com.example.elekt.preparefortest.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by elekt on 07.07.2017.
 */

class Task {
    private String question;
    private Map<String, Boolean> possibleAnswers = new HashMap<>();
    private String explanation;

    public Task(String question, Map<String, Boolean> possibleAnswers, String explanation) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.explanation = explanation;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, Boolean> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void addPossibleAnswers(String possibleAnswer, boolean isCorrect) {
        possibleAnswers.put(possibleAnswer, isCorrect);
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
