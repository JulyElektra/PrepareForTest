package com.example.elekt.preparefortest.Presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.elekt.preparefortest.Model.Level;
import com.example.elekt.preparefortest.Model.ProgrammingLanguage;
import com.example.elekt.preparefortest.Model.SQLite.DBHelper;
import com.example.elekt.preparefortest.Model.Test;
import com.example.elekt.preparefortest.Model.Topic;
import com.example.elekt.preparefortest.Model.User;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collection;

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
}
