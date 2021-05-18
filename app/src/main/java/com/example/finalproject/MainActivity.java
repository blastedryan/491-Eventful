package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b_newNote;

    String titles[], dates[], notes[], priorities[];
    int icon = R.drawable.icon;

    RecyclerView recyclerView;

    //database things; judy
    private NotesDatabase database;
    private NotesDao dao;
    private List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_newNote = (Button) findViewById(R.id.newNoteButton);//get id of new note button "+"

        b_newNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newNote();
            }
        });

        database = Room.databaseBulder(getApplicationContext(),
                NotesDatabase.class,
                "notes").allowMainThreadQueries().build();
        dao = database.dao();
    }
    public void newNote()
    {
        Intent intent = new Intent(this, NewNote.class);
        startActivity(intent);
    }
}