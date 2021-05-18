package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewNote extends AppCompatActivity {

    Button b_submit;
    EditText et_date, et_note, et_time, et_priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        /*
        b_submit = (Button) findViewById(R.id.addNoteButton);//get id of new note button "+"

        (Button) findViewById(R.id.newNoteButton);
        (Button) findViewById(R.id.newNoteButton);
        (Button) findViewById(R.id.newNoteButton);
        (Button) findViewById(R.id.newNoteButton);

        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notes note = new Notes();
                note.setTitle();
                note.setNote();
                note.setDate();
                note.setPriority();
            }
        });
         */

        // Get the Intent that started this activity and extract the string
        //Intent intent = getIntent();

    }
}



