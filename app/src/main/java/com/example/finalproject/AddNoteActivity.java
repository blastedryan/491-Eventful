package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class AddNoteActivity extends Activity implements View.OnClickListener {

    private Button addBtn;
    private EditText titleET, noteET, dateET, priorityET;
    DBManager dbManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("EventFul Add Note");
        setContentView(R.layout.activity_add_note);

        titleET = findViewById(R.id.titleEditText);
        noteET = findViewById(R.id.noteEditText);
        dateET = findViewById(R.id.dateEditText);
        priorityET = findViewById(R.id.numberEditText);
        addBtn = findViewById(R.id.addRecord);

        dbManager = new DBManager(this);
        dbManager.open();
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addRecord:
                String title = titleET.getText().toString();
                String note = noteET.getText().toString();
                String date = dateET.getText().toString();
                String priority = priorityET.getText().toString();

                dbManager.insert(title, note, date, priority);

                Intent main = new Intent(AddNoteActivity.this, ListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
        }
    }
}
