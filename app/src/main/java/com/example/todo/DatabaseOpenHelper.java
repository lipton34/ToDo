package com.example.todo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String FILE_NAME = "TODO_DATABASE";
    private static final String CREATE_TABLE = "CREATE TABLE `TODO_TABLE`(" + "`_id` INTEGER PRIMARY KEY AUTOINCREMENT," + "`title` TEXT,`content` TEXT" + ");";

    public DatabaseOpenHelper(Context context) {
        super(context, FILE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
