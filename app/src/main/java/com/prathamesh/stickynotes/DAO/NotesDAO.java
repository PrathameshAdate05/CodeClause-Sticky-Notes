package com.prathamesh.stickynotes.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.prathamesh.stickynotes.Model.Notes;

import java.util.List;

@Dao
public interface NotesDAO {

    @Query("SELECT * FROM Notes_DB")
    LiveData<List<Notes>> getAllNotes();

    @Insert
    void insertNote(Notes notes);

    @Query("DELETE FROM NOTES_DB WHERE id=:noteId")
    void deleteNote(int noteId);

    @Update
    void updateNote(Notes notes);
}
