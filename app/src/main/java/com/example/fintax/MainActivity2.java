package com.example.fintax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView4;
    TextView textView6;
    TextView textView7;
    TextView textView9;
    TextView textView10;
    TextView textView12;
    TextView textView11;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String str1 = getIntent().getStringExtra("old_1");
        String str2 = intent.getStringExtra("old_2");
        String strn1 = intent.getStringExtra("new_1");
        String strn2 = intent.getStringExtra("new_2");
        textView4 = findViewById(R.id.textView4);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView12 = findViewById(R.id.textView12);
        textView11 = findViewById(R.id.textView11);

        textView4.setText(str1);
        textView6.setText(str2);
        textView9.setText(strn1);
        textView10.setText(strn2);




    }
}