package com.prathamesh.stickynotes.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.prathamesh.stickynotes.DAO.NotesDAO;
import com.prathamesh.stickynotes.Database.NotesDatabase;
import com.prathamesh.stickynotes.Model.Notes;

import java.util.List;

public class NotesRepository {

    public NotesDAO notesDAO;

    public LiveData<List<Notes>> allNotes;

    public NotesRepository(Application application){
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDAO = database.notesDAO();
        allNotes = notesDAO.getAllNotes();
    }

    public void insertNotes(Notes notes){
        notesDAO.insertNote(notes);
    }

    public void deleteNotes(int id){
        notesDAO.deleteNote(id);
    }

    public void updateNotes(Notes notes){
        notesDAO.updateNote(notes);
    }
}
