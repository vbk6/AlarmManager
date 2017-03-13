package com.example.vishnubk.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;
    AlarmManager alarmManager;
    int i=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent myIntent = new Intent(MainActivity.this, AlarmReceiver.class);

        //myIntent.putExtra("i",--i);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);

            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            int interval = 10000;
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.add(Calendar.SECOND, 10);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),interval,pendingIntent);


                  // alarmManager.cancel(pendingIntent);
        Toast.makeText(MainActivity.this, "Start Alarm", Toast.LENGTH_LONG).show();
    }
}
