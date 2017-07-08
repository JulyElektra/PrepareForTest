package com.example.elekt.preparefortest.Model;

import java.util.Collection;
import java.util.logging.Level;

/**
 * Created by elekt on 07.07.2017.
 */

public interface IModel {
    Collection<String> getAllProgrammingLanguages() ;
    Collection<Level> getAllLevels();
    Collection<String> getAllTopics();
    Collection<Test> getTests(String programmingLanguage, String level, String topic);
    UserAccount getUser(String login);
    Collection<Task> getTasks(Test test);
}
