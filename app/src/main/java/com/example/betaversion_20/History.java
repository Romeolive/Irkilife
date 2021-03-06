package com.example.betaversion_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class History extends AppCompatActivity {

    Button first,second,third,four,to_next_btn_history;
    ScrollView scrollView_history;
    ImageView imageView_history;
    TextView textView_history, history_text;
    String answer = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    static String TAG = "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        for (Map.Entry<Integer, Integer> pair : Arrays.MAP_AR.entrySet()) {
            TextView textView1 = findViewById(pair.getKey());
            textView1.setBackgroundResource(pair.getValue());
        }



        textView_history = findViewById(R.id.levelOneQuestionHistory);
        history_text = findViewById(R.id.history_text);
        scrollView_history = findViewById(R.id.scroll_history);

        //TODO blocking of scroll in ScrollView
        scrollView_history.setOnTouchListener((view, motionEvent) -> true);

        first = findViewById(R.id.levelOneAnswerOneHistory);
        second = findViewById(R.id.levelOneAnswerTwoHistory);
        third = findViewById(R.id.levelOneAnswerThreeHistory);
        four = findViewById(R.id.levelOneAnswerFourHistory);
        to_next_btn_history = findViewById(R.id.to_next_button_History);
        imageView_history  = findViewById(R.id.image_view_history);

        if (Arrays.HISTORY_COUNTER == 12){

            Intent intent = new Intent(History.this,EndOfLevelPeople.class);
            intent.putExtra("results", String.valueOf(Arrays.COUNTER_OF_TRUE));
            startActivity(intent);
            overridePendingTransition(R.anim.to_next_like_list,R.anim.to_back);

            Arrays.COUNTER_OF_TRUE = 0;
            History.this.onDestroy();
        }

        DocumentReference docRef = db.collection(Arrays.LEVELS_NAMES_HISTORY[Arrays.HISTORY_COUNTER]).document(Arrays.LEVELS_NAMES_HISTORY[Arrays.HISTORY_COUNTER]);

        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    textView_history.setText(document.getData().get(Arrays.LEVELS_NAMES_HISTORY[Arrays.HISTORY_COUNTER]).toString());
                    first.setText(document.getData().get(Arrays.ANSWERS_NAMES_HISTORY[Arrays.HISTORY_COUNTER]+Arrays.NUMBERS[0]).toString());
                    second.setText(document.getData().get(Arrays.ANSWERS_NAMES_HISTORY[Arrays.HISTORY_COUNTER]+Arrays.NUMBERS[1]).toString());
                    third.setText(document.getData().get(Arrays.ANSWERS_NAMES_HISTORY[Arrays.HISTORY_COUNTER]+Arrays.NUMBERS[2]).toString());
                    four.setText(document.getData().get(Arrays.ANSWERS_NAMES_HISTORY[Arrays.HISTORY_COUNTER]+Arrays.NUMBERS[3]).toString());

                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "Get failed with ", task.getException());
            }
        });

        //TODO connecting the reboot function to the level
        //to_next_btn.setOnClickListener(view -> reload());
        to_next_btn_history.setOnClickListener(view -> reload());
        //TODO making the button invisible
        to_next_btn_history.setVisibility(View.GONE);


        //???????????? ????????????
        first.setOnClickListener(view -> {
            answer = first.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);

            //TODO allow to the ScrollView to scroll
            scrollView_history.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn_history.setVisibility(View.VISIBLE);
            scrollView_history.setNestedScrollingEnabled(true);
            scrollView_history.fullScroll(View.FOCUS_DOWN);

            if (answer.equals(Arrays.KEY_HISTORY[Arrays.HISTORY_COUNTER])) {
                TextView textView = findViewById(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                imageView_history.setImageResource(Arrays.IMAGES_HISTORY[Arrays.HISTORY_COUNTER]);
                first.setBackgroundColor(Color.GREEN);
                history_text.setText(Arrays.HISTORY_TEXT[Arrays.HISTORY_COUNTER]);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
            } else {
                first.setBackgroundColor(Color.RED);
                imageView_history.setImageResource(Arrays.IMAGES_HISTORY[Arrays.HISTORY_COUNTER]);
                history_text.setText(Arrays.HISTORY_TEXT[Arrays.HISTORY_COUNTER]);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);

            }
        });
        //???????????? ????????????
        second.setOnClickListener(view -> {
            answer = second.getText().toString();

            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);
            imageView_history.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_history.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn_history.setVisibility(View.VISIBLE);
            scrollView_history.setNestedScrollingEnabled(true);
            scrollView_history.fullScroll(View.FOCUS_DOWN);


            if (answer.equals(Arrays.KEY_HISTORY[Arrays.HISTORY_COUNTER])) {

                TextView textView = findViewById(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                second.setBackgroundColor(Color.GREEN);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
                history_text.setText(Arrays.HISTORY_TEXT[Arrays.HISTORY_COUNTER]);
                imageView_history.setImageResource(Arrays.IMAGES_HISTORY[Arrays.HISTORY_COUNTER]);
            } else {

                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                second.setBackgroundColor(Color.RED);
                history_text.setText(Arrays.HISTORY_TEXT[Arrays.HISTORY_COUNTER]);
                imageView_history.setImageResource(Arrays.IMAGES_HISTORY[Arrays.HISTORY_COUNTER]);


            }
        });

        //???????????? ????????????
        third.setOnClickListener(view -> {
            answer = third.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);
            imageView_history.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_history.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn_history.setVisibility(View.VISIBLE);
            scrollView_history.setNestedScrollingEnabled(true);
            scrollView_history.fullScroll(View.FOCUS_DOWN);


            if (answer.equals(Arrays.KEY_HISTORY[Arrays.HISTORY_COUNTER])) {

                TextView textView = findViewById(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                third.setBackgroundColor(Color.GREEN);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
                history_text.setText(Arrays.HISTORY_TEXT[Arrays.HISTORY_COUNTER]);
                imageView_history.setImageResource(Arrays.IMAGES_HISTORY[Arrays.HISTORY_COUNTER]);

            } else {


                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                third.setBackgroundColor(Color.RED);
                history_text.setText(Arrays.HISTORY_TEXT[Arrays.HISTORY_COUNTER]);
                imageView_history.setImageResource(Arrays.IMAGES_HISTORY[Arrays.HISTORY_COUNTER]);

            }
        });

        //?????????????????? ????????????
        four.setOnClickListener(view -> {
            answer = four.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);
            imageView_history.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_history.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn_history.setVisibility(View.VISIBLE);
            scrollView_history.setNestedScrollingEnabled(true);
            scrollView_history.fullScroll(View.FOCUS_DOWN);

            if (answer.equals(Arrays.KEY_HISTORY[Arrays.HISTORY_COUNTER])) {


                TextView textView = findViewById(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);

                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER],R.drawable.point_style_true);
                four.setBackgroundColor(Color.GREEN);
                Arrays.COUNTER_OF_TRUE+=1;
                history_text.setText(Arrays.HISTORY_TEXT[Arrays.HISTORY_COUNTER]);
                imageView_history.setImageResource(Arrays.IMAGES_HISTORY[Arrays.HISTORY_COUNTER]);

            } else {
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW_HISTORY[Arrays.HISTORY_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                four.setBackgroundColor(Color.RED);
                history_text.setText(Arrays.HISTORY_TEXT[Arrays.HISTORY_COUNTER]);
                imageView_history.setImageResource(Arrays.IMAGES_HISTORY[Arrays.HISTORY_COUNTER]);

            }
        });
    }
    //TODO ?????????? ???????????????????????? ???????????? ?? ?????????????????????? ???????????? ????????????(COUNTER)
    private void reload(){
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        Arrays.HISTORY_COUNTER+=1;
        finish();
        overridePendingTransition(0, 0);
        SharedPreferences.Editor ed = getSharedPreferences("level", Context.MODE_PRIVATE).edit();
        ed.putInt("number2", Arrays.COUNTER_OF_TRUE);
        ed.apply();
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this,R.style.MyDialogTheme)
                .setTitle("?????????? ?? ???????????????? ?????????")
                .setMessage("???? ?????????????????????????? ???????????? ???????????")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //People.super.onBackPressed();
                        startActivity(new Intent(History.this,MainActivity.class));
                        History.this.onDestroy();
                        Arrays.COUNTER = 0;
                        Arrays.COUNTER_OF_TRUE = 0;
                    }
                }).create().show();
    }





}
