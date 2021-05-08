package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b_newNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_newNote = (Button) findViewById(R.id.newNoteButton);//get id of new note button "+"

        b_newNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "newNote!", Toast.LENGTH_LONG).show();//display the text of button1
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