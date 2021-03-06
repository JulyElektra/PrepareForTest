package com.example.elekt.preparefortest.Model.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.elekt.preparefortest.Model.Level;
import com.example.elekt.preparefortest.Model.ProgrammingLanguage;
import com.example.elekt.preparefortest.Model.Task;
import com.example.elekt.preparefortest.Model.Topic;
import com.example.elekt.preparefortest.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by elekt on 08.07.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE levels (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL" +
                ");");
        db.execSQL("INSERT INTO levels(name) VALUES('All');");
        db.execSQL("INSERT INTO levels(name) VALUES('Junior');");
        db.execSQL("INSERT INTO levels(name) VALUES('Middle');");
        db.execSQL("INSERT INTO levels(name) VALUES('Senior');");

        db.execSQL("CREATE TABLE programming_languages (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL" +
                ");");
        db.execSQL("INSERT INTO programming_languages(name) VALUES('All');");
        db.execSQL("INSERT INTO programming_languages(name) VALUES('Java');");
        db.execSQL("INSERT INTO programming_languages(name) VALUES('C#');");
        db.execSQL("INSERT INTO programming_languages(name) VALUES('Python');");

        db.execSQL("CREATE TABLE topics (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "id_programming_language INTEGER NOT NULL, " +
                "FOREIGN KEY(id_programming_language) REFERENCES programming_languages(id));");
        db.execSQL("INSERT INTO topics(name, id_programming_language) VALUES('All', 1);");
        db.execSQL("INSERT INTO topics(name, id_programming_language) VALUES('Design patterns', 2);");
        db.execSQL("INSERT INTO topics(name, id_programming_language) VALUES('JVM', 3);");
        db.execSQL("INSERT INTO topics(name, id_programming_language) VALUES('Properties', 4);");


        db.execSQL("CREATE TABLE users (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "login TEXT NOT NULL," +
                "password TEXT NOT NULL" +
                ");");
        db.execSQL("INSERT INTO users(login, password) VALUES('admin', 'admin');");
        db.execSQL("INSERT INTO users(login, password) VALUES('yuliya', '123');");
        db.execSQL("INSERT INTO users(login, password) VALUES('q', 'q');");


        db.execSQL("CREATE TABLE tests (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "successfully_passed_percentage INTEGER NOT NULL," +
                "name TEXT NOT NULL," +
                "is_approved BOOLEAN," +
                "id_user_creator INTEGER NOT NULL, " +
                "id_programming_language INTEGER NOT NULL, " +
                "id_topic INTEGER NOT NULL, " +
                "id_level INTEGER NOT NULL, " +
                "time_limits_min INTEGER NOT NULL, " +
                "FOREIGN KEY(id_level) REFERENCES levels(id)," +
                "FOREIGN KEY(id_topic) REFERENCES topics(id)," +
                "FOREIGN KEY(id_user_creator) REFERENCES users(id)," +
                "FOREIGN KEY(id_programming_language) REFERENCES programming_languages(id));");
        db.execSQL("INSERT INTO tests(successfully_passed_percentage, name, is_approved, id_user_creator, id_programming_language, id_topic,id_level,time_limits_min ) " +
                "VALUES(90, 'Abstract Factory', 'TRUE', 1, 2, 2, 2, 20);");
        db.execSQL("INSERT INTO tests(successfully_passed_percentage, name, is_approved, id_user_creator, id_programming_language, id_topic,id_level,time_limits_min ) " +
                "VALUES(90, 'Singleton', 'TRUE', 1, 3, 2, 3, 45);");
        db.execSQL("INSERT INTO tests(successfully_passed_percentage, name, is_approved, id_user_creator, id_programming_language, id_topic,id_level,time_limits_min ) " +
                "VALUES(90, 'Builder', 'TRUE', 1, 4, 2, 4, 60);");

        db.execSQL("CREATE TABLE tasks (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "question TEXT NOT NULL," +
                "explanation TEXT NOT NULL," +
                "is_approved BOOLEAN," +
                "id_user_creator INTEGER NOT NULL, " +
                "id_test INTEGER NOT NULL, " +
                "code_chunk TEXT NOT NULL," +
                "FOREIGN KEY(id_test) REFERENCES tests(id)," +
                "FOREIGN KEY(id_user_creator) REFERENCES users(id));");
        db.execSQL("INSERT INTO tasks(question, explanation, is_approved, id_user_creator,id_test, code_chunk) " +
                "VALUES('What will be an output?', 'Because the weather is cold.', 'TRUE', 1, 1, 'System.out.println();');");
        db.execSQL("INSERT INTO tasks(question, explanation, is_approved, id_user_creator,id_test, code_chunk) " +
                "VALUES('How are you?', 'Great explanation!', 'TRUE', 1, 1, 'class Cat { \n}');");
        db.execSQL("INSERT INTO tasks(question, explanation, is_approved, id_user_creator,id_test, code_chunk) " +
                "VALUES('Will you come?', 'You are bad boy!', 'FALSE', 1, 1, '');");
        db.execSQL("INSERT INTO tasks(question, explanation, is_approved, id_user_creator,id_test, code_chunk) " +
                "VALUES('How old are you?', 'You lie', 'FALSE', 1, 1, '');");

        db.execSQL("CREATE TABLE answers (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "answer TEXT NOT NULL," +
                "is_correct BOOLEAN NOT NULL," +
                "id_task INTEGER NOT NULL, " +
                "FOREIGN KEY(id_task) REFERENCES tasks(id));");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('True', 'TRUE', 1);");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('False', 'FALSE', 1);");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('Compilation error', 'FALSE', 1);");

        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('Good','True',  2);");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('Bed','False',  2);");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('Do not know', 'FALSE', 2);");

        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('Yes','True', 3);");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('No','False',  3);");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('May be', 'FALSE', 3);");

        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('11','True', 4);");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('10','False',  4);");
        db.execSQL("INSERT INTO answers(answer, is_correct, id_task) VALUES('4444', 'FALSE', 4);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
