package com.example.betaversion_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelsActivity extends AppCompatActivity {

    Button peopleBtn,historyBtn,symbolBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        peopleBtn = findViewById(R.id.people);
        historyBtn =findViewById(R.id.history);
        symbolBtn = findViewById(R.id.symbol);

        peopleBtn.setOnClickListener(view -> startActivity(new Intent(LevelsActivity.this,People.class)));
        historyBtn.setOnClickListener(view -> startActivity(new Intent(LevelsActivity.this,History.class)));
        symbolBtn.setOnClickListener(view -> startActivity(new Intent(LevelsActivity.this, Symbol.class)));
    }
}