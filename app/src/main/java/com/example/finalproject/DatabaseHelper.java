package com.example.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    // table name
    public static final String TABLE_NAME ="EVENTFUL";

    // table columns:
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String NOTE = "note";
    public static final String DATE = "date";
    public static final String PRIORITY = "priority";

    // database
    static final String DB_NAME = "EVENTFUL.DB";
    static final int DB_VERSION = 1;

    // Table Query:
    private static final String CREATE_TABLE = "create table " +
            TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TITLE + " TEXT NOT NULL, " + NOTE + " TEXT, " +
            DATE + " TEXT NOT NULL, " + PRIORITY + " TEXT NOT NULL);";

    // constructor
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
