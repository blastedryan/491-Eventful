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
    EditText et_date, et_note, et_date, et_time et_priority;
    /*

  <TextView
        android:id="@+id/NoteTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Note:"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.098" />

    <EditText
        android:id="@+id/dateET"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="date"
        android:hint="Date"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.196" />

    <EditText
        android:id="@+id/timeET"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="time"
        android:hint="Time:"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.307" />

    <EditText
        android:id="@+id/noteET"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:hint="Note Details"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

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

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

    }
}


