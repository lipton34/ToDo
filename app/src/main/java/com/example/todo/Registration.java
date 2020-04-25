package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

    @Override
    protected void onResume() {
        super.onResume();

        View UpdateBtn = findViewById(R.id.update_btn_reg);
        UpdateBtn.setOnClickListener(v -> {
            EditText titleEdit = findViewById(R.id.title_edit);
            EditText contentEdit = findViewById(R.id.content_edit);

            SQLiteOpenHelper sqLiteOpenHelper;
            SQLiteDatabase database = null;

            try{
                sqLiteOpenHelper = new DatabaseOpenHelper(getApplicationContext());
                database = sqLiteOpenHelper.getWritableDatabase();

                ContentValues cv = new ContentValues();
                cv.put("title",titleEdit.getText().toString());
                cv.put("content",contentEdit.getText().toString());
                database.insert("TODO_TABLE",null,cv);


            }
            catch (Exception ex){

            }finally {
                database.close();
            }
            Toast.makeText(Registration.this,"登録完了しました",Toast.LENGTH_LONG);
            Log.v("クリック確認","押されています");
        });
    }
}
