package com.example.elekt.preparefortest.Model.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        db.execSQL("INSERT INTO topics(name, id_programming_language) VALUES('All', 0);");
        db.execSQL("INSERT INTO topics(name, id_programming_language) VALUES('Design patterns', 1);");
        db.execSQL("INSERT INTO topics(name, id_programming_language) VALUES('JVM', 2);");
        db.execSQL("INSERT INTO topics(name, id_programming_language) VALUES('Properties', 3);");


        db.execSQL("CREATE TABLE users (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "login TEXT NOT NULL," +
                "password TEXT NOT NULL" +
                ");");
        db.execSQL("INSERT INTO users(login, password) VALUES('admin', 'admin');");
        db.execSQL("INSERT INTO users(login, password) VALUES('yuliya', '123');");
        db.execSQL("INSERT INTO users(login, password) VALUES('q', 'q');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
