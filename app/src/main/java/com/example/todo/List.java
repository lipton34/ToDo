package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class List extends ListActivity {
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SQLiteOpenHelper sqLiteOpenHelper = new DatabaseOpenHelper(this);
        SQLiteDatabase database = null;

        try {

            database = sqLiteOpenHelper.getReadableDatabase();

            cursor = database.query("TODO_TABLE",null,null,null,null,null,null);
            SimpleCursorAdapter adapter;
            adapter = new SimpleCursorAdapter(this,R.layout.lisst_part,cursor,new String[]{"TITLE"},new int[]{R.id.list_part}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
            setListAdapter(adapter);

        }catch (Exception ex){

        }finally {
            database.close();
        }

    }



}


