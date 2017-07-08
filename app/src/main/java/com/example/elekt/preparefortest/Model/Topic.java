package com.example.elekt.preparefortest.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by elekt on 07.07.2017.
 */

public class Topic implements INameable {
    private Long id;
    private String name;
    private Long programmingLanguageID;

    public Topic(Long id, String name, Long programmingLanguageID) {
        this.name = name;
        this.programmingLanguageID = programmingLanguageID;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProgrammingLanguage() {
        return programmingLanguageID;
    }

    public void setProgrammingLanguage(Long programmingLanguageID) {
        this.programmingLanguageID = programmingLanguageID;
    }
}
