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
    private EditText titleET, noteET, priorityET;
    //DBManager dbManager;
    private Calendar myCalendar = Calendar.getInstance();
    private long delay = 0;
    private Date datein;
    DatePicker simpleDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Intent intent = getIntent();
        setTitle("EventFul Add Note");

        titleET = findViewById(R.id.titleEditText);
        noteET = findViewById(R.id.noteEditText);
        /*simpleDatePicker = (DatePicker)findViewById(R.id.datePicker); // initiate a date picker
        simpleDatePicker.setSpinnersShown(false); // set false value for the spinner shown function

        /*dateET = findViewById(R.id.dateEditText);
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
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addClick(v);
            }
        });*/
        });


    }

    public void addClick(View v) {
        switch (v.getId()) {
            case R.id.addRecord:
                String title = titleET.getText().toString();
                String note = noteET.getText().toString();
                String myFormat = "mm/dd/yy" ;
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat , Locale.getDefault ()) ;
                String date = sdf.format(datein);
                String priority = priorityET.getText().toString();

                //dbManager.insert(title, note, date, priority);
                String NOTIFICATION_CHANNEL_ID;
                //switch for whatever priority chosen
                if(Integer.parseInt(priority) == 3) {//high
                    NOTIFICATION_CHANNEL_ID = "10001";
                }else if(Integer.parseInt(priority) == 2) {//norm
                    NOTIFICATION_CHANNEL_ID = "10002";
                }else{//low
                    NOTIFICATION_CHANNEL_ID = "10003";
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        AddNoteActivity.this, NOTIFICATION_CHANNEL_ID)
                        .setContentTitle(title)
                        .setContentText(note)
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
    }
}
