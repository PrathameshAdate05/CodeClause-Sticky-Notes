package com.prathamesh.stickynotes;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.Locale;

public class ShowNote extends AppCompatActivity {

    TextView TV_Title, TV_Date, TV_NoteData;
    String title, date, noteData;
    TextToSpeech textToSpeech;
    FloatingActionButton FAB_Speak,FAB_Translate;
    boolean state = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);

        setTitle(R.string.show_note_title);

        title = getIntent().getStringExtra("noteTitle");
        date = getIntent().getStringExtra("noteDate");
        noteData = getIntent().getStringExtra("noteData");

        TV_Title = findViewById(R.id.TV_Show_Note);
        TV_Date = findViewById(R.id.TV_Show_Date);
        TV_NoteData = findViewById(R.id.TV_Show_Note_Data);
        TV_NoteData.setMovementMethod(new ScrollingMovementMethod());
        TV_Title.setMovementMethod(new ScrollingMovementMethod());

        FAB_Speak = findViewById(R.id.FAB_TTS);


        TV_Title.setText(title);
        TV_Date.setText(date);
        TV_NoteData.setText(noteData);


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);

                    textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        @Override
                        public void onStart(String s) {
                            Toast.makeText(ShowNote.this, s, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onDone(String s) {

                        }

                        @Override
                        public void onError(String s) {

                        }
                    });
                } else {
                    Toast.makeText(ShowNote.this, "Error Reading the note...!", Toast.LENGTH_SHORT).show();
                }


            }
        });


        FAB_Speak.setOnClickListener(view -> {
            if (!state) {
                FAB_Speak.setImageResource(R.drawable.ic_baseline_pause_24);
                String sentence = "Reading the Note. \n Title is. " + title + ".\n Date is. " + date + ".\n Note is. " + noteData
                        + ". Note Reading Complete. Thank You for using our Service...";
                textToSpeech.speak(sentence, TextToSpeech.QUEUE_FLUSH, null);
                state = true;
            } else {
                textToSpeech.stop();
                FAB_Speak.setImageResource(R.drawable.speaker_icon);
                state = false;
            }
        });
    }



    @Override
    protected void onPause() {
        textToSpeech.shutdown();
        finish();
        super.onPause();
    }
}