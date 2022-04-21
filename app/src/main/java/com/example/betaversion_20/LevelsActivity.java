package com.example.betaversion_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelsActivity extends AppCompatActivity {

    Button peopleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        peopleBtn = findViewById(R.id.people);
        peopleBtn.setOnClickListener(view -> {
            Intent intent = new Intent(LevelsActivity.this,People.class);
            startActivity(intent);
        });
    }
}