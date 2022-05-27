package com.example.betaversion_20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class EndOfLevelPeople extends AppCompatActivity {

    Button to_menu;
    TextView results, present;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_level_people);

        Random random = new Random();
        int value = random.nextInt(3);

        to_menu = findViewById(R.id.to_menu_btn_from_win);
        results = findViewById(R.id.result_of_level_int);
        present = findViewById(R.id.present);

        Intent intent1 = getIntent();
        String result = intent1.getStringExtra("results");
        results.setText(result+"/"+12);
        present.setText(Arrays.COORDINATES[value]);



        to_menu.setOnClickListener(view -> {

            ClipboardManager clipboard = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", present.getText().toString());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getApplicationContext(), "Подарок скопирован в буфер", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(EndOfLevelPeople.this, MainActivity.class);

            startActivity(intent);
            EndOfLevelPeople.this.finish();
        });

    }

}