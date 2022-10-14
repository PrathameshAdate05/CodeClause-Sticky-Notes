package com.prathamesh.stickynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {

    FloatingActionButton fab;
    Button show , update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab = findViewById(R.id.FAB_CreateNote);

        show = findViewById(R.id.temp_show);
        update = findViewById(R.id.temp_update);

        show.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,ShowNote.class);
            startActivity(intent);
        });

        update.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,UpdateNote.class);
            startActivity(intent);
        });

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,NewNote.class);
            startActivity(intent);
        });
    }
}