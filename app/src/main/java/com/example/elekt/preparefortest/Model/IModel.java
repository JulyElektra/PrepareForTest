package com.example.elekt.preparefortest.Model;

import java.util.Collection;
import java.util.logging.Level;

/**
 * Created by elekt on 07.07.2017.
 */

public interface IModel {
    Collection<ProgrammingLanguage> getAllProgrammingLanguages() ;
    Collection<com.example.elekt.preparefortest.Model.Level> getAllLevels();
    Collection<Topic> getAllTopics();
    Collection<Test> getTests(String programmingLanguage, String level, String topic);
    Collection<Task> getTasks(Test test);
    void addTest(Test newTest);
    void addTask(Test test, Task newTask);
    Collection<User> getUsers();
    User getUser(String login);
    void addUser(String login, String password);
    void blockUser(User user);

}
