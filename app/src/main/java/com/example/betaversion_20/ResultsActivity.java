package com.example.betaversion_20;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView first,second,third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        first = findViewById(R.id.results_first);
        second = findViewById(R.id.results_second);
        third = findViewById(R.id.results_third);

        SharedPreferences sharedPreferences = getSharedPreferences("level",MODE_PRIVATE);
        int results1 = sharedPreferences.getInt("number1",1);
        int results2 = sharedPreferences.getInt("number2",1);
        int results3 = sharedPreferences.getInt("number3",1);
        first.setText(String.valueOf(results1));
        second.setText(String.valueOf(results2));
        third.setText(String.valueOf(results3));

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("value", true)){
            Intent intent = new Intent(ResultsActivity.this, BackgroundMusicService.class);
            startService(intent);
        }
    }
}