package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class ModifyActivity extends Activity implements View.OnClickListener {

    private Button modifyBtn, deleteBtn;
    private EditText titleET, noteET, dateET, priorityET;
    private DBManager dbManager;
    private long _id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("EventFul Modify Note");;
        setContentView(R.layout.activity_modify_note);

        dbManager = new DBManager(this);
        dbManager.open();

        // get the Edit Views.
        titleET = findViewById(R.id.titleEditText);
        noteET = findViewById(R.id.noteEditText);
        dateET = findViewById(R.id.dateEditText);
        priorityET = findViewById(R.id.numberEditText);
        modifyBtn = findViewById(R.id.modifyRecord);
        deleteBtn = findViewById(R.id.deleteButton);

        // get thee saved values.
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        String note = intent.getStringExtra("note");
        String date = intent.getStringExtra("date");
        String priority = intent.getStringExtra("priority");

        // set the values.
        _id = Long.parseLong(id);
        titleET.setText(title);
        noteET.setText(note);
        dateET.setText(date);
        priorityET.setText(priority);

        // modify and delete on click listeners.
        modifyBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    // modify or delete the record.
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.modifyRecord:
                String title = titleET.getText().toString();
                String note = noteET.getText().toString();
                String date = dateET.getText().toString();
                String priority = priorityET.getText().toString();

                dbManager.update(_id, title, note, date, priority);
                this.goHome();
                break;

            case R.id.deleteButton:
                dbManager.delete(_id);
                this.goHome();
                break;
        }
    }

    // go back to the home activity.
    private void goHome() {
        Intent home = new Intent(getApplicationContext(), ListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);
    }
}
