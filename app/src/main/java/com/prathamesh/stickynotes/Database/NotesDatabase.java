package com.prathamesh.stickynotes.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.prathamesh.stickynotes.DAO.NotesDAO;
import com.prathamesh.stickynotes.Model.Notes;

@Database(entities = Notes.class,version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDAO notesDAO();

    public static NotesDatabase INSTANCE;
    public static NotesDatabase getDatabaseInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),NotesDatabase.class,"Notes_DB").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
