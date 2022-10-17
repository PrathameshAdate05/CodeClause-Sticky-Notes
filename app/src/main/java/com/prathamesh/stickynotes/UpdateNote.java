package com.prathamesh.stickynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
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

public class UpdateNote extends AppCompatActivity {

    EditText ET_Title, ET_Note_Data;
    FloatingActionButton FAB_Update;
    String title;
    String noteData;
    int id;
    NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);
        setTitle(R.string.update_note_title);

        ET_Title = findViewById(R.id.ET_Update_Title);
        ET_Note_Data = findViewById(R.id.ET_Update_Note);
        FAB_Update = findViewById(R.id.FAB_Update_Note);

        id = getIntent().getIntExtra("noteId",0);
        title = getIntent().getStringExtra("noteTitle");
        noteData = getIntent().getStringExtra("noteData");

        ET_Title.setText(title);
        ET_Note_Data.setText(noteData);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        FAB_Update.setOnClickListener(view -> {
            String tempTitle = ET_Title.getText().toString();
            String tempNoteData = ET_Note_Data.getText().toString();

            updateNote(tempTitle, tempNoteData);
        });
    }

    private void updateNote(String tempTitle, String tempNoteData) {
        DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        Calendar calendar = Calendar.getInstance();

        Notes updateNotes = new Notes();
        updateNotes.noteTitle = tempTitle;
        updateNotes.id = id;
        updateNotes.noteData = tempNoteData;
        updateNotes.noteDate = dateFormat.format(calendar.getTime());

        notesViewModel.updateNote(updateNotes);
        Toast.makeText(this, "Notes Updated Successfully...", Toast.LENGTH_SHORT).show();
        finish();
    }
}