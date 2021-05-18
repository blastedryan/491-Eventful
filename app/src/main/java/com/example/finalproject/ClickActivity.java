package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ClickActivity extends AppCompatActivity {

    TextView title, date, note, priority;
    String  s1, s2, s3, s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        title = findViewById(R.id.titleText);
        date = findViewById(R.id.dateText);
        note = findViewById(R.id.noteText);
        priority = findViewById(R.id.priorityText);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("Title") &&
                getIntent().hasExtra("Date") &&
                getIntent().hasExtra("Note") &&
                getIntent().hasExtra("Priority")) {
            s1 = getIntent().getStringExtra("Title");
            s2 = getIntent().getStringExtra("Date");
            s3 = getIntent().getStringExtra("Note");
            s4 = getIntent().getStringExtra("Priority");
        }

        else {
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(s1);
        date.setText(s2);
        note.setText(s3);
        priority.setText(s4);
    }
}