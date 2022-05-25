package com.example.betaversion_20;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;




public class SettingsActivity extends AppCompatActivity {

    Button to_menu;
    SwitchCompat music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);




        to_menu = findViewById(R.id.to_menu_btn);
        music = findViewById(R.id.music);

        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        music.setChecked(sharedPreferences.getBoolean("value", true));



        to_menu.setOnClickListener(view -> {
            Intent intent1 = new Intent(SettingsActivity.this, MainActivity.class);

            SharedPreferences.Editor ed = getSharedPreferences("test", Context.MODE_PRIVATE).edit();
            ed.putBoolean("value",music.isChecked());
            ed.apply();

            startActivity(intent1);
            SettingsActivity.this.onStop();
        });





        music.setOnClickListener(view -> {

            if (music.isChecked()){

                Intent intent2 = new Intent(SettingsActivity.this, BackgroundMusicService.class);
                startService(intent2);
            }
            else{
                Intent intent2 = new Intent(SettingsActivity.this, BackgroundMusicService.class);
                stopService(intent2);
            }

        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("value", true)){
            Intent intent = new Intent(SettingsActivity.this, BackgroundMusicService.class);
            startService(intent);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor ed = getSharedPreferences("test", Context.MODE_PRIVATE).edit();
        ed.putBoolean("value",music.isChecked());
        ed.apply();
        stopService(new Intent(SettingsActivity.this, BackgroundMusicService.class));

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor ed = getSharedPreferences("test", Context.MODE_PRIVATE).edit();
        ed.putBoolean("value",music.isChecked());
        ed.apply();
        stopService(new Intent(SettingsActivity.this, BackgroundMusicService.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor ed = getSharedPreferences("test", Context.MODE_PRIVATE).edit();
        ed.putBoolean("value",music.isChecked());
        ed.apply();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences.Editor ed = getSharedPreferences("test", Context.MODE_PRIVATE).edit();
        ed.putBoolean("value",music.isChecked());
        ed.apply();
        startService(new Intent(SettingsActivity.this, BackgroundMusicService.class));

    }
}