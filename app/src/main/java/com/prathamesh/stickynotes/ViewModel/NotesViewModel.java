package com.prathamesh.stickynotes.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.prathamesh.stickynotes.Model.Notes;
import com.prathamesh.stickynotes.Repository.NotesRepository;

import java.util.List;


public class NotesViewModel extends AndroidViewModel {

    public NotesRepository notesRepository;
    public LiveData<List<Notes>> getAllNotes;

    public NotesViewModel(@NonNull Application application) {
        super(application);

        notesRepository = new NotesRepository(application);
        getAllNotes = notesRepository.allNotes;
    }

    public void insertNote(Notes notes) {
        notesRepository.insertNotes(notes);
    }

    public void deleteNote(int id) {
        notesRepository.deleteNotes(id);
    }

    public void updateNote(Notes notes) {
        notesRepository.updateNotes(notes);
    }
}
