package com.prathamesh.stickynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab = findViewById(R.id.FAB_CreateNote);

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,NewNote.class);
            startActivity(intent);
        });
    }
}