package com.example.finalproject;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.ListActivity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddNoteActivity extends AppCompatActivity {

    private Button addBtn;
    private EditText titleET, noteET, dateET, priorityET;
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private EditText titleET, noteET, priorityET;
>>>>>>> parent of 11910fa (combine changes from ryan's push with working add view?)
=======
>>>>>>> parent of 15e5e1c (combine changes from ryan's push with working add view?)
    //DBManager dbManager;
    //private Calendar myCalendar = Calendar.getInstance();
    private long delay = 0;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private Date datein;
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 11910fa (combine changes from ryan's push with working add view?)
    private Date datein;
>>>>>>> parent of a1f531a (removed auto github labels)
    DatePicker simpleDatePicker;
<<<<<<< HEAD
=======
    private Date datein = Calendar.getInstance().getTime();
>>>>>>> ac16c084d96f6c39ee81f0144fef5ab6a43160a5
<<<<<<< HEAD
=======
    private Date datein;
>>>>>>> parent of ac16c08 (fixed notifications)
=======
>>>>>>> parent of 303a511 (replacing new note with add note)
=======
>>>>>>> parent of a1f531a (removed auto github labels)
=======
>>>>>>> parent of 11910fa (combine changes from ryan's push with working add view?)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Intent intent = getIntent();
        setTitle("EventFul Add Note");

        titleET = findViewById(R.id.titleEditText);
<<<<<<< HEAD
<<<<<<< HEAD
        noteET = findViewById(R.id.noteEditText);
        /*simpleDatePicker = (DatePicker)findViewById(R.id.datePicker); // initiate a date picker
        simpleDatePicker.setSpinnersShown(false); // set false value for the spinner shown function

        /*dateET = findViewById(R.id.dateEditText);
<<<<<<< HEAD
=======
=======
        /*noteET = findViewById(R.id.noteEditText);
>>>>>>> parent of ac16c08 (fixed notifications)
        dateET = findViewById(R.id.dateEditText);
>>>>>>> ac16c084d96f6c39ee81f0144fef5ab6a43160a5
=======
        /*noteET = findViewById(R.id.noteEditText);
        dateET = findViewById(R.id.dateEditText);
>>>>>>> parent of 303a511 (replacing new note with add note)
=======
>>>>>>> parent of 11910fa (combine changes from ryan's push with working add view?)
        priorityET = findViewById(R.id.numberEditText);
        addBtn = findViewById(R.id.addRecord);

        //dbManager = new DBManager(this);
        //dbManager.open();

        /*dateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        datein = myCalendar.getTime();
                        Date currentTime = Calendar.getInstance().getTime();
                        delay = datein.getTime() - currentTime.getTime();

                    }
                };
                new DatePickerDialog(
                        AddNoteActivity.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        /*addBtn.setOnClickListener(new View.OnClickListener() {
<<<<<<< HEAD
<<<<<<< HEAD
=======
        addBtn.setOnClickListener(new View.OnClickListener() {
>>>>>>> parent of 11910fa (combine changes from ryan's push with working add view?)
=======
>>>>>>> parent of 15e5e1c (combine changes from ryan's push with working add view?)
            @Override
            public void onClick(View v) {
                addClick(v);
            }
        });*/
<<<<<<< HEAD
<<<<<<< HEAD
=======
        });
>>>>>>> parent of 11910fa (combine changes from ryan's push with working add view?)
=======
>>>>>>> parent of 15e5e1c (combine changes from ryan's push with working add view?)


    }

    /*public void addClick(View v) {
        switch (v.getId()) {
            case R.id.addRecord:
                String title = titleET.getText().toString();
                String note = noteET.getText().toString();
                String myFormat = "mm/dd/yy" ;
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat , Locale.getDefault ()) ;
                String date = sdf.format(datein);
                String priority = priorityET.getText().toString();

                //dbManager.insert(title, note, date, priority);

                String NOTIFICATION_CHANNEL_ID = "10001";//switch for whatever priority chosen
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        AddNoteActivity.this, NOTIFICATION_CHANNEL_ID)
                        .setContentTitle("Title")
                        .setContentText("Body")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_MAX) //for old versions
                        .setChannelId(NOTIFICATION_CHANNEL_ID);//for old versions

                scheduleNotification(builder.build(), delay);


                Intent main = new Intent(AddNoteActivity.this, ListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
        }
    }
    private void scheduleNotification(Notification notification, long delay) {
        Intent notificationIntent = new Intent(this, NotificationUtil.class);
        notificationIntent.putExtra(NotificationUtil.NOTIFICATION_ID, 1);//unique id
        notificationIntent.putExtra(NotificationUtil.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
<<<<<<< HEAD
<<<<<<< HEAD
    }*/
=======
    }
>>>>>>> parent of a1f531a (removed auto github labels)
=======
    }*/
>>>>>>> parent of 15e5e1c (combine changes from ryan's push with working add view?)
}
