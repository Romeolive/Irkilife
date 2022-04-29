package com.example.betaversion_20;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Button play, results;
    Button setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setting = findViewById(R.id.settings_btn);
        play = findViewById(R.id.play_menu_btn);
        results = findViewById(R.id.result_menu_btn);

        setting.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            MainActivity.this.onStop();

        });

        play.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LevelsActivity.class);
            startActivity(intent);
            MainActivity.this.onStop();
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("value", true)){
            Intent intent = new Intent(MainActivity.this, BackgroundMusicService.class);
            startService(intent);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("value", true)){
            Intent intent = new Intent(MainActivity.this, BackgroundMusicService.class);
            startService(intent);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        stopService(new Intent(MainActivity.this, BackgroundMusicService.class));

        Intent intent = new Intent(MainActivity.this, AlarmManag.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long time = 1000*2;



    }

    @Override
    protected void onStop() {
        super.onStop();

        Calendar notifyTime = Calendar.getInstance();
        notifyTime.setTimeInMillis(System.currentTimeMillis());
        int day = notifyTime.get(Calendar.HOUR_OF_DAY);
        if (day >= 10){
            notifyTime.add(Calendar.DATE,1);
        }
        notifyTime.set(Calendar.HOUR_OF_DAY,10);
        notifyTime.set(Calendar.MINUTE, 0);
        notifyTime.set(Calendar.SECOND,0);


        Intent intent = new Intent(MainActivity.this, AlarmManag.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long time = 3600000;


        //alarmManager.set(AlarmManager.RTC_WAKEUP,time,pendingIntent);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, notifyTime.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }
}
