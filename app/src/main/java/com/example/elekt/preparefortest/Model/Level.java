package com.example.elekt.preparefortest.Model;

import android.util.Log;

/**
 * Created by elekt on 08.07.2017.
 */

public class Level implements INameable {
    private Long id;
    private String name;

    public Level(Long id, String name) {
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
