package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    // Constructor
    public DBManager(Context c) {
        context = c;

    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String title, String note, String date, String priority){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.TITLE, title);
        contentValues.put(DatabaseHelper.NOTE, note);
        contentValues.put(DatabaseHelper.DATE, date);
        contentValues.put(DatabaseHelper.PRIORITY, priority);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }


    // fetch a cursor for the database.
    public Cursor fetch() {
        String[] columns = new String[] {DatabaseHelper.ID,
                DatabaseHelper.TITLE, DatabaseHelper.NOTE, DatabaseHelper.DATE,
                DatabaseHelper.PRIORITY};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null,
                null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    // update the information on an existing note.
    public int update(long id, String title, String note, String date, String priority) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.TITLE, title);
        contentValues.put(DatabaseHelper.NOTE, note);
        contentValues.put(DatabaseHelper.DATE, date);
        contentValues.put(DatabaseHelper.PRIORITY, priority);

        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.ID +
                " = " + id, null);
        return i;
    }

    // delete the note.
    public void delete(long id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.ID + " = " + id,
                null);
    }
}
