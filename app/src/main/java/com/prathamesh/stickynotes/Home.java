package com.prathamesh.stickynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,NewNote.class);
            startActivity(intent);
        });
    }
}