package com.prathamesh.stickynotes.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prathamesh.stickynotes.Home;
import com.prathamesh.stickynotes.Model.Notes;
import com.prathamesh.stickynotes.R;
import com.prathamesh.stickynotes.ShowNote;
import com.prathamesh.stickynotes.UpdateNote;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    Home home;
    List<Notes> notes;

    public NotesAdapter(Home home, List<Notes> notes) {
        this.home = home;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(home).inflate(R.layout.note_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Notes note = notes.get(position);

        holder.cardTitle.setText(note.noteTitle);
        holder.cardNoteData.setText(note.noteData);
        holder.cardDay.setText(note.noteDate.substring(0,2));
        holder.cardMonth.setText(note.noteDate.substring(3,7));
        holder.cardYear.setText(note.noteDate.substring(7,11));


        // opening show note activity
        holder.linearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(home, ShowNote.class);
            intent.putExtra("noteTitle", note.noteTitle);
            intent.putExtra("noteData",note.noteData);
            intent.putExtra("noteDate",note.noteDate);
            home.startActivity(intent);

            Toast.makeText(home, "Reading Mode...", Toast.LENGTH_SHORT).show();
        });

        // opening update note activity
        holder.cardEdit.setOnClickListener(view -> {
            Intent intent = new Intent(home, UpdateNote.class);
            intent.putExtra("noteId", note.id);
            intent.putExtra("noteTitle", note.noteTitle);
            intent.putExtra("noteData",note.noteData);
            home.startActivity(intent);
        });

        // setting onclick on menus for each card
        holder.cardShare.setOnClickListener(view -> {
            Toast.makeText(home, note.noteTitle, Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView cardYear, cardMonth, cardDay, cardTitle, cardNoteData;
        ImageView cardShare, cardEdit, cardDelete;
        LinearLayout linearLayout;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            cardYear = itemView.findViewById(R.id.TV_Card_Year);
            cardMonth = itemView.findViewById(R.id.TV_Card_Month);
            cardDay = itemView.findViewById(R.id.TV_Card_Day);
            cardTitle = itemView.findViewById(R.id.TV_Card_Title);
            cardNoteData = itemView.findViewById(R.id.TV_Card_Note);

            cardEdit = itemView.findViewById(R.id.IV_Card_Edit);
            cardShare = itemView.findViewById(R.id.IV_Card_Share);
            cardDelete = itemView.findViewById(R.id.IV_Card_Delete);

            linearLayout = itemView.findViewById(R.id.CARD_Click_Linear_Layout);
        }
    }

}
