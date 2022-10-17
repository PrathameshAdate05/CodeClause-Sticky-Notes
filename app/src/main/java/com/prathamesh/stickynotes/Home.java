package com.prathamesh.stickynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prathamesh.stickynotes.Adapter.NotesAdapter;
import com.prathamesh.stickynotes.ViewModel.NotesViewModel;

public class Home extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    NotesViewModel notesViewModel;
    NotesAdapter adapter;
    ImageView IV_Empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab = findViewById(R.id.FAB_CreateNote);
        IV_Empty = findViewById(R.id.IV_Home_Empty);
        IV_Empty.setVisibility(View.GONE);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        recyclerView = findViewById(R.id.RecyclerView);

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this, NewNote.class);
            startActivity(intent);
        });

        notesViewModel.getAllNotes.observe(this, notes -> {

            if (notes.size() == 0){
                recyclerView.setVisibility(View.GONE);
                IV_Empty.setVisibility(View.VISIBLE);
            }
            else{
                IV_Empty.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                adapter = new NotesAdapter(Home.this, notes);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}