package com.prathamesh.stickynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prathamesh.stickynotes.Model.Notes;
import com.prathamesh.stickynotes.ViewModel.NotesViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewNote extends AppCompatActivity {

    EditText ET_Title, ET_Note_Data;
    FloatingActionButton save;
    String noteTitle, noteData;
    NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        ET_Title = findViewById(R.id.ET_New_Title);
        ET_Note_Data = findViewById(R.id.ET_New_Note);
        save = findViewById(R.id.FAB_SaveNote);

        save.setOnClickListener(view -> {

            if (ET_Title.getText().toString().equals(""))
                ET_Title.setError("Enter Input");
            else if (ET_Note_Data.getText().toString().equals(""))
                ET_Note_Data.setError("Enter Input");
            else {
                noteTitle = ET_Title.getText().toString();
                noteData = ET_Note_Data.getText().toString();

                createNote(noteTitle, noteData);
            }

        });
    }

    public void createNote(String title, String data) {

        DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        Calendar calendar = Calendar.getInstance();

        Notes notes = new Notes();
        notes.noteTitle = title;
        notes.noteData = data;
        notes.noteDate = dateFormat.format(calendar.getTime());

        notesViewModel.insertNote(notes);
        Toast.makeText(this, "Notes Saved Successfully...", Toast.LENGTH_SHORT).show();
        finish();
    }
}