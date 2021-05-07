package com.example.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper.ID, DatabaseHelper.TITLE,
            DatabaseHelper.NOTE, DatabaseHelper.DATE, DatabaseHelper.PRIORITY };

    final int[] to = new int[] { R.id.id, R.id.title, R.id.note, R.id.date, R.id.priority };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);

        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record,
                cursor, from, to, 0);

        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, viewId) -> {
            TextView idTextView = view.findViewById(R.id.id);
            TextView titleTextView = view.findViewById(R.id.title);
            TextView noteTextView = view.findViewById(R.id.note);
            TextView dateTextView = view.findViewById(R.id.date);
            TextView priorityTextView = view.findViewById(R.id.priority);

            String id = idTextView.getText().toString();
            String title = titleTextView.getText().toString();
            String note = noteTextView.getText().toString();
            String date = dateTextView.getText().toString();
            String priority = priorityTextView.getText().toString();

            Intent modify_intent = new Intent(getApplicationContext(),
                    ModifyActivity.class);

            modify_intent.putExtra("title", title);
            modify_intent.putExtra("note", note);
            modify_intent.putExtra("date", date);
            modify_intent.putExtra("priority", priority);
            startActivity(modify_intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.addRecord) {
            Intent addNote = new Intent(this, AddNoteActivity.class);
            startActivity(addNote);
        }

        return super.onOptionsItemSelected(item);
    }
}
