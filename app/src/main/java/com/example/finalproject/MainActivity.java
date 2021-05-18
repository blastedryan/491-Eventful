package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b_newNote; // Joodi

    String titles[], dates[], notes[], priorities[];
    int icon = R.drawable.icon;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ced's code
        recyclerView = findViewById(R.id.recyclerView);

        // replace getResources() with info from database
        titles = getResources().getStringArray(R.array.Title);
        dates = getResources().getStringArray(R.array.Date);
        notes = getResources().getStringArray(R.array.Note);
        priorities = getResources().getStringArray(R.array.Priority);

        MyAdapter myAdapter = new MyAdapter(this, titles, dates, notes, priorities, icon);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Joodi's code
        b_newNote = (Button) findViewById(R.id.newNoteButton); //get id of new note button "+"

        b_newNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newNote();
            }
        });
    }

    public void newNote()
    {
        Intent intent = new Intent(this, NewNote.class);
        startActivity(intent);
    }
}