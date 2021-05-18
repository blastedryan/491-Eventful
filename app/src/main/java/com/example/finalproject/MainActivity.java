package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b_newNote; // Joodi

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
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("10001", "High Importance", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationChannel = new NotificationChannel("10002", "Normal Importance", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationChannel = new NotificationChannel("10003", "Low Importance", NotificationManager.IMPORTANCE_LOW);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        // Ced's code
        recyclerView = findViewById(R.id.recyclerView);

        notesList = database.dao().getAll();
        int count = database.dao().countNotes();

        Notes note;

        List<String> t = new ArrayList<String>();
        List<String> d = new ArrayList<String>();
        List<String> n = new ArrayList<String>();
        List<String> p = new ArrayList<String>();

        if (count > 0) {

            // loop and add each note element.
            for (int i = 0; i < count; i++) {
                note = notesList.get(i);
                t.add(note.getTitle());
                d.add(note.getDate());
                n.add(note.getNote());
                p.add(note.getPriority());
            }
        }

        // replace getResources() with info from database
        /*
        titles = getResources().getStringArray(R.array.Title);
        dates = getResources().getStringArray(R.array.Date);
        notes = getResources().getStringArray(R.array.Note);
        priorities = getResources().getStringArray(R.array.Priority);
        */

        MyAdapter myAdapter = new MyAdapter(this, (String[]) t.toArray(),
                (String[]) d.toArray(),
                (String[]) n.toArray(),
                (String[]) p.toArray(),
                icon);

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
        database = Room.databaseBuilder(getApplicationContext(),
                NotesDatabase.class,
                "notes").allowMainThreadQueries().build();
        dao = database.dao();

        Intent intent = new Intent(this, NewNote.class);
        startActivity(intent);
    }
}