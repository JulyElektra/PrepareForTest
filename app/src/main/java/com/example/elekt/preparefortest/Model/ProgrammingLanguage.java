package com.example.elekt.preparefortest.Model;

/**
 * Created by elekt on 07.07.2017.
 */

public class ProgrammingLanguage implements INameable {
    private Long id;
    private String name;

    public ProgrammingLanguage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
