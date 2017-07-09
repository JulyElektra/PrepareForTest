package com.example.elekt.preparefortest.Model;

import android.content.Context;

import com.example.elekt.preparefortest.Model.SQLite.DBHelper;
import com.example.elekt.preparefortest.Model.SQLite.DBManager;

import java.util.Collection;

/**
 * Created by elekt on 08.07.2017.
 */

public class Model implements IModel {
    private DBManager dbManager;

    public Model(Context context) {
        DBHelper helper = new DBHelper(context, "prepare_for_test_bd", null, 1);
        dbManager = new DBManager(helper);
    }

    @Override
    public Collection<ProgrammingLanguage> getAllProgrammingLanguages() {
        return dbManager.loadAllProgrammingLanguages();
    }

    @Override
    public Collection<Level> getAllLevels() {
        return dbManager.loadAllLevels();
    }

    @Override
    public Collection<Topic> getAllTopics() {
        return dbManager.loadAllTopics();
    }

    @Override
    public Collection<Test> getTests(String programmingLanguage, String level, String topic) {
        return dbManager.loadTests(programmingLanguage, level, topic);
    }

    @Override
    public Collection<Task> getTasks(Test test) {
        return dbManager.loadTasks(test.getId());
    }

    @Override
    public void addTest(Test newTest) {

    }

    @Override
    public void addTask(Test test, Task newTask) {

    }

    @Override
    public Collection<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(String login) {
        return dbManager.loadUser(login);
    }

    @Override
    public void blockUser(User user) {

    }

    @Override
    public void addUser(String login, String password) {
        dbManager.addUser(login, password);
    }
}
