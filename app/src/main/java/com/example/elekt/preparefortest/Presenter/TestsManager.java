package com.example.elekt.preparefortest.Presenter;

import com.example.elekt.preparefortest.Model.Level;
import com.example.elekt.preparefortest.Model.ProgrammingLanguage;
import com.example.elekt.preparefortest.Model.Test;
import com.example.elekt.preparefortest.Model.Topic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by elekt on 07.07.2017.
 */

public class TestsManager implements IManager {
    private static TestsManager testManager;
//    private Collection<Level> levels = new ArrayList<>();
//    private Collection<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
//    private Collection<Topic> topics = new ArrayList<>();

    static {
        testManager = new TestsManager();
    }

    private TestsManager() {
    }

    public static TestsManager getInstance() {
        return testManager;
    }

    @Override
    public void add(Object object) {

    }

    @Override
    public Object remove(Object object) {
        return null;
    }

    public void approve(Test test){

    }
    public void reject(Test test) {

    }

//    public void addLevel(long id, String level) {
//        levels.add(new Level(id, level));
//    }
//
//    public void addProgrammingLanguage(long id, String programingLanguage) {
//        programmingLanguages.add(new ProgrammingLanguage(id, programingLanguage));
//    }
//
//    public void addTopic(long id, String topic, ProgrammingLanguage programmingLanguage) {
//        topics.add(new Topic(id, topic, programmingLanguage));
//    }
}
