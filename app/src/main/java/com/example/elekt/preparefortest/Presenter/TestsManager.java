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
    private static Collection<Test> testsCurrent;

    static {
        testManager = new TestsManager();
    }

    private TestsManager() {
    }


    public static Collection<Test> getTestsCurrent() {
        return testsCurrent;
    }

    public static void setTestsCurrent(Collection<Test> testsCurrent) {
        TestsManager.testsCurrent = testsCurrent;
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

}
