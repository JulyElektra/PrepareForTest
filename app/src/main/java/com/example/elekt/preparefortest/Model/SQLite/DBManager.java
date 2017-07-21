package com.example.elekt.preparefortest.Model.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.elekt.preparefortest.Model.Level;
import com.example.elekt.preparefortest.Model.ProgrammingLanguage;
import com.example.elekt.preparefortest.Model.SQLite.DBHelper;
import com.example.elekt.preparefortest.Model.Task;
import com.example.elekt.preparefortest.Model.Test;
import com.example.elekt.preparefortest.Model.Topic;
import com.example.elekt.preparefortest.Model.User;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by elekt on 08.07.2017.
 */

public class DBManager {
    private final DBHelper helper;

//    private TestsManager testsManager = TestsManager.getInstance();

    public DBManager(DBHelper helper) {
        this.helper = helper;
    }

    public Collection<Level> loadAllLevels() {

        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("levels", null, null,null,null,null,null);
        Collection<Level> levels = new ArrayList<>();
        while (cursor.moveToNext()) {

            Level level = new Level(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                    cursor.getString(cursor.getColumnIndex("name")));
            levels.add(level);
        }
        return levels;
    }

    public Collection<ProgrammingLanguage> loadAllProgrammingLanguages() {
//        DBHelper helper = new DBHelper(context, "prepare_for_test_bd", null, 1);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("programming_languages", null, null,null,null,null,null);
        Collection<ProgrammingLanguage> programmingLanguage = new ArrayList<>();
        while (cursor.moveToNext()) {
            ProgrammingLanguage programmingLanguage1 = new ProgrammingLanguage(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                    cursor.getString(cursor.getColumnIndex("name")));
            programmingLanguage.add(programmingLanguage1);
        }
        return programmingLanguage;
    }

    public Collection<Topic> loadAllTopics() {
//        DBHelper helper = new DBHelper(context, "prepare_for_test_bd", null, 1);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("topics", null, null,null,null,null,null);
        Collection<Topic> topics = new ArrayList<>();
        while (cursor.moveToNext()) {
            Topic topic = new Topic(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                    cursor.getString(cursor.getColumnIndex("name")),
                    Long.parseLong(cursor.getString(cursor.getColumnIndex("id_programming_language"))));
            topics.add(topic);
        }
        return topics;
    }

    public User loadUser(String login) {
//        DBHelper helper = new DBHelper(context, "prepare_for_test_bd", null, 1);
        SQLiteDatabase database = helper.getWritableDatabase();
        try {
            Cursor cursor = database.query("users", null, "login = '" + login + "'" ,null,null,null,null);
            cursor.moveToNext();
            User user = new User(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                    cursor.getString(cursor.getColumnIndex("login")),
                    cursor.getString(cursor.getColumnIndex("password")));
            return user;
        }catch (SQLiteException e) {
            e.printStackTrace();
            return null;
        }catch (CursorIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addUser(String login, String password) {
        SQLiteDatabase database = helper.getWritableDatabase();
        database.execSQL("INSERT INTO users(login, password) VALUES('" + login + "', '" + password + "');");
    }

    public Collection<Test> loadTests(String programmingLanguageStr, String levelStr, String topicStr) {
        SQLiteDatabase database = helper.getWritableDatabase();
        if (programmingLanguageStr == "All"){

        }
        ProgrammingLanguage programmingLanguageFilter = loadProgrammingLanguage(programmingLanguageStr);
        Topic topicFilter = loadTopic(topicStr);
        Level levelFilter = loadLevel(levelStr);

        String equalsTopicId = " = '" + topicFilter.getId() + "'";
        String equalsLevelId = " = '" + levelFilter.getId() + "'";
        String equalsProgrammingLanguageId = " = '" + programmingLanguageFilter.getId() + "'";

        if (programmingLanguageStr.equals("All")) {
            equalsProgrammingLanguageId = " IS NOT NULL ";
        }
        if (levelStr.equals("All")) {
            equalsLevelId = " IS NOT NULL ";
        }
        if (topicStr.equals("All")) {
            equalsTopicId = " IS NOT NULL ";
        }

        Cursor cursor = database.query("tests", null,
                "id_programming_language " + equalsProgrammingLanguageId + " AND " +
                        "id_topic " + equalsTopicId + " AND " +
                        "id_level " + equalsLevelId ,null,null,null,null);
        Collection<Test> tests = new ArrayList<>();
        while (cursor.moveToNext()) {
            Long idProgrammingLanguage = Long.parseLong(cursor.getString(cursor.getColumnIndex("id_programming_language")));
            Long idTopic = Long.parseLong(cursor.getString(cursor.getColumnIndex("id_topic")));
            Long idLevel = Long.parseLong(cursor.getString(cursor.getColumnIndex("id_level")));
            ProgrammingLanguage programmingLanguage = loadProgrammingLanguage(idProgrammingLanguage);
            Topic topic = loadTopic(idTopic);
            Level level = loadLevel(idLevel);
            Long id = Long.parseLong(cursor.getString(cursor.getColumnIndex("id")));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            Long idCreator = Long.parseLong(cursor.getString(cursor.getColumnIndex("id_user_creator")));
            User creator = loadUser(idCreator);
            Boolean isApproved = Boolean.valueOf(cursor.getString(cursor.getColumnIndex("is_approved")));
            Collection<Task> tasks = loadTasks(id);
            Integer timeLimits = Integer.parseInt(cursor.getString(cursor.getColumnIndex("time_limits_min")));
            Integer successfullyPassedPercentage = Integer.parseInt(cursor.getString(cursor.getColumnIndex("successfully_passed_percentage")));;
            Test test = new Test(id, name, programmingLanguage, topic, level, tasks, timeLimits, creator, isApproved, successfullyPassedPercentage);
            tests.add(test);

        }
        return tests;
    }

    private Level loadLevel(Long idLevel) {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("levels", null, "id = '" + idLevel + "'",null,null,null,null);
        cursor.moveToNext();
        Level level = new Level(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                cursor.getString(cursor.getColumnIndex("name")));
        return level;
    }

    private Topic loadTopic(Long idTopic) {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("topics", null, "id = '" + idTopic + "'",null,null,null,null);
        cursor.moveToNext();
        Topic topic = new Topic(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                cursor.getString(cursor.getColumnIndex("name")),
                Long.parseLong(cursor.getString(cursor.getColumnIndex("id_programming_language"))));
        return topic;
    }

    private ProgrammingLanguage loadProgrammingLanguage(Long idProgrammingLanguage) {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("programming_languages", null,
                "id = '" + idProgrammingLanguage  + "'", null,null,null,null);
        cursor.moveToNext();
        ProgrammingLanguage programmingLanguage1 = new ProgrammingLanguage(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                cursor.getString(cursor.getColumnIndex("name")));
        return programmingLanguage1;
    }

    private Level loadLevel(String levelStr) {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("levels", null, "name = '" + levelStr+ "'",null,null,null,null);
        cursor.moveToNext();
        Level level = new Level(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                cursor.getString(cursor.getColumnIndex("name")));
        return level;
    }

    private Topic loadTopic(String topicStr) {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("topics", null, "name = '" + topicStr+ "'",null,null,null,null);
        cursor.moveToNext();
        Topic topic = new Topic(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                cursor.getString(cursor.getColumnIndex("name")),
        Long.parseLong(cursor.getString(cursor.getColumnIndex("id_programming_language"))));
        return topic;
    }

    private ProgrammingLanguage loadProgrammingLanguage(String programmingLanguageStr) {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("programming_languages", null,
                "name = '" + programmingLanguageStr  + "'", null,null,null,null);
        cursor.moveToNext();
        ProgrammingLanguage programmingLanguage1 = new ProgrammingLanguage(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                    cursor.getString(cursor.getColumnIndex("name")));
        return programmingLanguage1;
    }

    public Collection<Task> loadTasks(Long idTest) {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("tasks", null,  "id_test = '" + idTest + "'",null,null,null,null);
        Collection<Task> tasks = new ArrayList<>();
        while (cursor.moveToNext()) {
            Long id = Long.parseLong(cursor.getString(cursor.getColumnIndex("id")));
            String question = cursor.getString(cursor.getColumnIndex("question"));
            String explanation = cursor.getString(cursor.getColumnIndex("explanation"));
            Long idCreator = Long.parseLong(cursor.getString(cursor.getColumnIndex("id_user_creator")));
            User creator = loadUser(idCreator);
            Boolean isApproved = Boolean.valueOf(cursor.getString(cursor.getColumnIndex("is_approved")));
            String codeChunk = cursor.getString(cursor.getColumnIndex("code_chunk"));
            Task task = new Task(id, question, getPossibleAnswers(id), explanation, creator, isApproved, codeChunk);
            tasks.add(task);

        }
        return tasks;
    }

    private User loadUser(Long idCreator) {
        SQLiteDatabase database = helper.getWritableDatabase();
        try {
            Cursor cursor = database.query("users", null, "id = '" + idCreator + "'" ,null,null,null,null);
            cursor.moveToNext();
            User user = new User(Long.parseLong(cursor.getString(cursor.getColumnIndex("id"))),
                    cursor.getString(cursor.getColumnIndex("login")),
                    cursor.getString(cursor.getColumnIndex("password")));
            return user;
        }catch (SQLiteException e) {
            e.printStackTrace();
            return null;
        }catch (CursorIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String,Boolean> getPossibleAnswers(Long idTask) {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("answers", null,  "id_task = '" + idTask + "'",null,null,null,null);
        Map<String,Boolean> answers = new HashMap<>();
        while (cursor.moveToNext()) {
            String answer = cursor.getString(cursor.getColumnIndex("answer"));
            Boolean isCorrect = Boolean.valueOf(cursor.getString(cursor.getColumnIndex("is_correct")));
            answers.put(answer,isCorrect);

        }
        return answers;
    }
}
