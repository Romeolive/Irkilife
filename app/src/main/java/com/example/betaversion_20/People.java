package com.example.betaversion_20;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.Map;

public class People extends AppCompatActivity {

    Button first,second,third,four,to_next_btn;
    ScrollView scrollView_people;
    ImageView imageView;
    TextView textView, akimov_text;
    String answer = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    static String TAG = "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        for (Map.Entry<Integer, Integer> pair : Arrays.MAP_AR.entrySet()) {
            TextView textView1 = findViewById(pair.getKey());
            textView1.setBackgroundResource(pair.getValue());
        }

        textView = findViewById(R.id.levelOneQuestion);
        akimov_text = findViewById(R.id.akimov_text);
        scrollView_people = findViewById(R.id.scroll_people);

        //TODO blocking of scroll in ScrollView
        scrollView_people.setOnTouchListener((view, motionEvent) -> true);

        first = findViewById(R.id.levelOneAnswerOne);
        second = findViewById(R.id.levelOneAnswerTwo);
        third = findViewById(R.id.levelOneAnswerThree);
        four = findViewById(R.id.levelOneAnswerFour);
        to_next_btn = findViewById(R.id.to_next_button);
        imageView  = findViewById(R.id.image_view);

        if (Arrays.COUNTER == 12){

                Intent intent = new Intent(People.this,EndOfLevelPeople.class);
                intent.putExtra("results", String.valueOf(Arrays.COUNTER_OF_TRUE));
                startActivity(intent);
                overridePendingTransition(R.anim.to_next_like_list,R.anim.to_back);

           Arrays.COUNTER_OF_TRUE = 0;
           Arrays.COUNTER = 0;
           People.this.finish();
        }

        DocumentReference docRef = db.collection(Arrays.LEVELS_NAMES_PEOPLE[Arrays.COUNTER]).document(Arrays.LEVELS_NAMES_PEOPLE[Arrays.COUNTER]);

        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    textView.setText(document.getData().get(Arrays.LEVELS_NAMES_PEOPLE[Arrays.COUNTER]).toString());
                    first.setText(document.getData().get(Arrays.ANSWERS_NAMES_PEOPLE[Arrays.COUNTER]+Arrays.NUMBERS[0]).toString());
                    second.setText(document.getData().get(Arrays.ANSWERS_NAMES_PEOPLE[Arrays.COUNTER]+Arrays.NUMBERS[1]).toString());
                    third.setText(document.getData().get(Arrays.ANSWERS_NAMES_PEOPLE[Arrays.COUNTER]+Arrays.NUMBERS[2]).toString());
                    four.setText(document.getData().get(Arrays.ANSWERS_NAMES_PEOPLE[Arrays.COUNTER]+Arrays.NUMBERS[3]).toString());

                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "Get failed with ", task.getException());
            }
        });

        //TODO connecting the reboot function to the level
        //to_next_btn.setOnClickListener(view -> reload());
        to_next_btn.setOnClickListener(view -> reload());
        //TODO making the button invisible
        to_next_btn.setVisibility(View.GONE);


        //первая кнопка
        first.setOnClickListener(view -> {
            answer = first.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);

            //TODO allow to the ScrollView to scroll
            scrollView_people.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn.setVisibility(View.VISIBLE);
            scrollView_people.setNestedScrollingEnabled(true);
            scrollView_people.fullScroll(View.FOCUS_DOWN);

            if (answer.equals(Arrays.KEY_PEOPLE[Arrays.COUNTER])) {
                TextView textView = findViewById(Arrays.TEXT_VIEW[Arrays.COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                imageView.setImageResource(Arrays.IMAGES[Arrays.COUNTER]);
                first.setBackgroundColor(Color.GREEN);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW[Arrays.COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
            } else {
                first.setBackgroundColor(Color.RED);
                imageView.setImageResource(Arrays.IMAGES[Arrays.COUNTER]);
                akimov_text.setText(R.string.app_name);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW[Arrays.COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW[Arrays.COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);

            }
        });
        //вторая кнопка
        second.setOnClickListener(view -> {
            answer = second.getText().toString();

            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);
            imageView.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_people.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn.setVisibility(View.VISIBLE);
            scrollView_people.setNestedScrollingEnabled(true);
            scrollView_people.fullScroll(View.FOCUS_DOWN);


            if (answer.equals(Arrays.KEY_PEOPLE[Arrays.COUNTER])) {

                TextView textView = findViewById(Arrays.TEXT_VIEW[Arrays.COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                second.setBackgroundColor(Color.GREEN);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW[Arrays.COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
                imageView.setImageResource(Arrays.IMAGES[Arrays.COUNTER]);
            } else {

                Arrays.MAP_AR.put(Arrays.TEXT_VIEW[Arrays.COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW[Arrays.COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                second.setBackgroundColor(Color.RED);
                imageView.setImageResource(Arrays.IMAGES[Arrays.COUNTER]);


            }
        });

        //третья кнопка
        third.setOnClickListener(view -> {
            answer = third.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);
            imageView.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_people.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn.setVisibility(View.VISIBLE);
            scrollView_people.setNestedScrollingEnabled(true);
            scrollView_people.fullScroll(View.FOCUS_DOWN);


            if (answer.equals(Arrays.KEY_PEOPLE[Arrays.COUNTER])) {


                TextView textView = findViewById(Arrays.TEXT_VIEW[Arrays.COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                third.setBackgroundColor(Color.GREEN);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW[Arrays.COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
                imageView.setImageResource(Arrays.IMAGES[Arrays.COUNTER]);

            } else {


                Arrays.MAP_AR.put(Arrays.TEXT_VIEW[Arrays.COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW[Arrays.COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                third.setBackgroundColor(Color.RED);
                imageView.setImageResource(Arrays.IMAGES[Arrays.COUNTER]);

            }
        });

        //четвертая кнопка
        four.setOnClickListener(view -> {
            answer = four.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);
            imageView.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_people.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn.setVisibility(View.VISIBLE);
            scrollView_people.setNestedScrollingEnabled(true);
            scrollView_people.fullScroll(View.FOCUS_DOWN);

            if (answer.equals(Arrays.KEY_PEOPLE[Arrays.COUNTER])) {


                TextView textView = findViewById(Arrays.TEXT_VIEW[Arrays.COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);

                Arrays.MAP_AR.put(Arrays.TEXT_VIEW[Arrays.COUNTER],R.drawable.point_style_true);
                four.setBackgroundColor(Color.GREEN);
                Arrays.COUNTER_OF_TRUE+=1;
                imageView.setImageResource(Arrays.IMAGES[Arrays.COUNTER]);

            } else {
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW[Arrays.COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW[Arrays.COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                four.setBackgroundColor(Color.RED);
                imageView.setImageResource(Arrays.IMAGES[Arrays.COUNTER]);

            }
        });

    }
    //TODO метод перезагрузки экрана с увеличением номера уровня(COUNTER)
    private void reload(){
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        Arrays.COUNTER+=1;
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Выйти в основное меню?")
                .setMessage("Вы действительно хотите выйти?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //People.super.onBackPressed();
                        startActivity(new Intent(People.this,MainActivity.class));
                       People.this.onDestroy();
                       Arrays.COUNTER = 0;
                       Arrays.COUNTER_OF_TRUE = 0;
                    }
                }).create().show();
    }
}