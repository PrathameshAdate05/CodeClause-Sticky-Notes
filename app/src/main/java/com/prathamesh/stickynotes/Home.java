package com.prathamesh.stickynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prathamesh.stickynotes.Adapter.NotesAdapter;
import com.prathamesh.stickynotes.ViewModel.NotesViewModel;

public class Home extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    NotesViewModel notesViewModel;
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab = findViewById(R.id.FAB_CreateNote);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        recyclerView = findViewById(R.id.RecyclerView);

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,NewNote.class);
            startActivity(intent);
        });



        notesViewModel.getAllNotes.observe(this,notes -> {
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                adapter = new NotesAdapter(Home.this,notes);
                recyclerView.setAdapter(adapter);
        });
    }
}