package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View regist = findViewById(R.id.registration_btn);
        regist.setOnClickListener((view)->{
            Intent intent = new Intent(MainActivity.this,Registration.class);
            startActivity(intent);
        });


        View list = findViewById(R.id.listing_btn);
        list.setOnClickListener((View)->{
            Intent intent = new Intent(MainActivity.this, List.class);
            startActivity(intent);
        });
    }
}
