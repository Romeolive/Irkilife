package com.example.betaversion_20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivity extends AppCompatActivity {

    Button send;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        send = findViewById(R.id.send_suggest);
        editText = findViewById(R.id.edit_suggest);
        send.setOnClickListener(view -> {

            Send("erre","eerer");

        });
    }
    public void Send(String addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:livshitsroman225@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT,editText.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,editText.getText().toString());
        intent.putExtra(Intent.EXTRA_TITLE,editText.getText().toString());
        //intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Письмо отправлено",Toast.LENGTH_SHORT).show();

    }
}