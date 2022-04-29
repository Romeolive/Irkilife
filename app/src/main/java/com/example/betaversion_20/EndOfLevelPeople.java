package com.example.betaversion_20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EndOfLevelPeople extends AppCompatActivity {

    Button to_menu;
    TextView results;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_level_people);

        to_menu = findViewById(R.id.to_menu_btn_from_win);
        results = findViewById(R.id.result_of_level_int);


        Intent intent1 = getIntent();
        String result = intent1.getStringExtra("results");
        results.setText(result+"/"+12);

        to_menu.setOnClickListener(view -> {
            Intent intent = new Intent(EndOfLevelPeople.this, MainActivity.class);

            startActivity(intent);
            EndOfLevelPeople.this.finish();
        });


    }
}