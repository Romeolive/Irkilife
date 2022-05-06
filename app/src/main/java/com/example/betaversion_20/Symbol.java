package com.example.betaversion_20;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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

public class Symbol extends AppCompatActivity {

    Button first,second,third,four,to_next_btn_symbol;
    ScrollView scrollView_symbol;
    ImageView imageView_symbol;
    TextView textView_symbol, symbol_text;
    String answer = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    static String TAG = "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symbol);

        for (Map.Entry<Integer, Integer> pair : Arrays.MAP_AR.entrySet()) {
            TextView textView1 = findViewById(pair.getKey());
            textView1.setBackgroundResource(pair.getValue());
        }

        textView_symbol = findViewById(R.id.levelOneQuestionSymbol);
        symbol_text = findViewById(R.id.symbol_text);
        scrollView_symbol = findViewById(R.id.scroll_symbol);

        //TODO blocking of scroll in ScrollView
        scrollView_symbol.setOnTouchListener((view, motionEvent) -> true);

        first = findViewById(R.id.levelOneAnswerOneSymbol);
        second = findViewById(R.id.levelOneAnswerTwoSymbol);
        third = findViewById(R.id.levelOneAnswerThreeSymbol);
        four = findViewById(R.id.levelOneAnswerFourSymbol);
        to_next_btn_symbol = findViewById(R.id.to_next_button_Symbol);
        imageView_symbol  = findViewById(R.id.image_view_symbol);

        if (Arrays.SYMBOL_COUNTER == 12){

            Intent intent = new Intent(Symbol.this,EndOfLevelPeople.class);
            intent.putExtra("results", String.valueOf(Arrays.COUNTER_OF_TRUE));
            startActivity(intent);
            overridePendingTransition(R.anim.to_next_like_list,R.anim.to_back);

            Arrays.COUNTER_OF_TRUE = 0;
            Symbol.this.finish();
        }

        DocumentReference docRef = db.collection(Arrays.LEVEL_NAMES_SYMBOLS[Arrays.SYMBOL_COUNTER]).document(Arrays.LEVEL_NAMES_SYMBOLS[Arrays.SYMBOL_COUNTER]);

        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    textView_symbol.setText(document.getData().get(Arrays.LEVEL_NAMES_SYMBOLS[Arrays.SYMBOL_COUNTER]).toString());
                    first.setText(document.getData().get(Arrays.ANSWERS_NAMES_SYMBOLS[Arrays.SYMBOL_COUNTER]+Arrays.NUMBERS[0]).toString());
                    second.setText(document.getData().get(Arrays.ANSWERS_NAMES_SYMBOLS[Arrays.SYMBOL_COUNTER]+Arrays.NUMBERS[1]).toString());
                    third.setText(document.getData().get(Arrays.ANSWERS_NAMES_SYMBOLS[Arrays.SYMBOL_COUNTER]+Arrays.NUMBERS[2]).toString());
                    four.setText(document.getData().get(Arrays.ANSWERS_NAMES_SYMBOLS[Arrays.SYMBOL_COUNTER]+Arrays.NUMBERS[3]).toString());

                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "Get failed with ", task.getException());
            }
        });

        //TODO connecting the reboot function to the level
        //to_next_btn.setOnClickListener(view -> reload());
        to_next_btn_symbol.setOnClickListener(view -> reload());
        //TODO making the button invisible
        to_next_btn_symbol.setVisibility(View.GONE);


        //первая кнопка
        first.setOnClickListener(view -> {
            answer = first.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);

            //TODO allow to the ScrollView to scroll
            scrollView_symbol.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn_symbol.setVisibility(View.VISIBLE);
            scrollView_symbol.setNestedScrollingEnabled(true);
            scrollView_symbol.fullScroll(View.FOCUS_DOWN);

            if (answer.equals(Arrays.KEY_SYMBOLS[Arrays.SYMBOL_COUNTER])) {
                TextView textView = findViewById(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                imageView_symbol.setImageResource(Arrays.IMAGES[Arrays.SYMBOL_COUNTER]);
                first.setBackgroundColor(Color.GREEN);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
            } else {
                first.setBackgroundColor(Color.RED);
                imageView_symbol.setImageResource(Arrays.IMAGES[Arrays.SYMBOL_COUNTER]);
                symbol_text.setText(R.string.app_name);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER]);
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
            imageView_symbol.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_symbol.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn_symbol.setVisibility(View.VISIBLE);
            scrollView_symbol.setNestedScrollingEnabled(true);
            scrollView_symbol.fullScroll(View.FOCUS_DOWN);


            if (answer.equals(Arrays.KEY_SYMBOLS[Arrays.SYMBOL_COUNTER])) {

                TextView textView = findViewById(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                second.setBackgroundColor(Color.GREEN);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
                imageView_symbol.setImageResource(Arrays.IMAGES[Arrays.SYMBOL_COUNTER]);
            } else {

                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                second.setBackgroundColor(Color.RED);
                imageView_symbol.setImageResource(Arrays.IMAGES[Arrays.SYMBOL_COUNTER]);


            }
        });

        //третья кнопка
        third.setOnClickListener(view -> {
            answer = third.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);
            imageView_symbol.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_symbol.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn_symbol.setVisibility(View.VISIBLE);
            scrollView_symbol.setNestedScrollingEnabled(true);
            scrollView_symbol.fullScroll(View.FOCUS_DOWN);


            if (answer.equals(Arrays.KEY_SYMBOLS[Arrays.SYMBOL_COUNTER])) {


                TextView textView = findViewById(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);
                third.setBackgroundColor(Color.GREEN);
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER],R.drawable.point_style_true);
                Arrays.COUNTER_OF_TRUE+=1;
                imageView_symbol.setImageResource(Arrays.IMAGES[Arrays.SYMBOL_COUNTER]);

            } else {


                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                third.setBackgroundColor(Color.RED);
                imageView_symbol.setImageResource(Arrays.IMAGES[Arrays.SYMBOL_COUNTER]);

            }
        });

        //четвертая кнопка
        four.setOnClickListener(view -> {
            answer = four.getText().toString();
            first.setClickable(false);
            second.setClickable(false);
            third.setClickable(false);
            four.setClickable(false);
            imageView_symbol.setImageResource(R.drawable.tree);
            //TODO allow to the ScrollView to scroll
            scrollView_symbol.setOnTouchListener((view1, motionEvent) -> false);
            //TODO making button visible
            to_next_btn_symbol.setVisibility(View.VISIBLE);
            scrollView_symbol.setNestedScrollingEnabled(true);
            scrollView_symbol.fullScroll(View.FOCUS_DOWN);

            if (answer.equals(Arrays.KEY_SYMBOLS[Arrays.SYMBOL_COUNTER])) {


                TextView textView = findViewById(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_true);

                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER],R.drawable.point_style_true);
                four.setBackgroundColor(Color.GREEN);
                Arrays.COUNTER_OF_TRUE+=1;
                imageView_symbol.setImageResource(Arrays.IMAGES[Arrays.SYMBOL_COUNTER]);

            } else {
                Arrays.MAP_AR.put(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER],R.drawable.point_style_false);
                TextView textView = findViewById(Arrays.TEXT_VIEW_SYMBOL[Arrays.SYMBOL_COUNTER]);
                textView.setBackgroundResource(R.drawable.point_style_false);
                four.setBackgroundColor(Color.RED);
                imageView_symbol.setImageResource(Arrays.IMAGES[Arrays.SYMBOL_COUNTER]);

            }
        });
    }
    //TODO метод перезагрузки экрана с увеличением номера уровня(COUNTER)
    private void reload(){
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        Arrays.SYMBOL_COUNTER+=1;
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
}
