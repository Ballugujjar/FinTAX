package com.example.fintax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText editTextNumber;
    EditText editTextNumber1;
    EditText editTextNumber2;
    EditText editTextNumber3;
    Button button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public int calculate_new(int h){
        int sum = 0;
        if(h<500000){
            return sum;
        }
        h = h-250000;
        if(h>250000){
            sum = sum + 250000*5/100;
            h = h-250000;
        }
        else{
            return sum;
        }
        if(h>250000){
            sum = sum + 250000*10/100;
            h=h-250000;
        }
        else{
            sum = sum + h*10/100;
            return (int) (sum*1.04);
        }
        if(h>250000){
            sum = sum + 250000*15/100;
            h=h-250000;
        }
        else{
            sum = sum + h*15/100;
            return (int) (sum*1.04);
        }

        if(h>250000){
            sum = sum + 250000*20/100;
            h=h-250000;
        }
        else{
            sum = sum + h*20/100;
            return (int) (sum*1.04);
        }

        if(h>250000){
            sum = sum + 250000*25/100;
            h=h-250000;
        }
        else{
            sum = sum + h*25/100;
            return (int) (sum*1.04);
        }
        sum = sum + h*30/100;
        return (int) (sum*1.04);
    }
    public int calculate_old(int h){
        int sum = 0;
        if(h<596600){
            return sum;
        }
        h = h-250000;
        h = h-96600;
        if(h>250000){
            sum = sum + 250000*5/100;
            h = h-250000;
        }
        else{
            return (int) (sum*1.04);
        }
        if(h>500000){
            sum = sum + 500000*20/100;
            h=h-500000;
        }
        else{
            sum = sum + h*20/100;
            return (int) (sum*1.04);
        }

        sum = sum + h*30/100;
        return (int) (sum*1.04);
    }


    public void calculation(View view) {
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber1 = findViewById(R.id.editTextNumber2);
        editTextNumber2 = findViewById(R.id.editTextNumber3);
        editTextNumber3 = findViewById(R.id.editTextNumber4);
        textView = findViewById(R.id.textView);
        String b;
        b = editTextNumber.getText().toString();
        int basic;
        try

        {
            // the String to int conversion happens here
             basic = Integer.parseInt(b.trim());

        }
        catch (NumberFormatException nfe)
        {
             basic = 0;
        }

        String h = editTextNumber1.getText().toString();
        int hra;

        try
        {
            // the String to int conversion happens here
            hra = Integer.parseInt(h.trim());

        }
        catch (NumberFormatException nfe)
        {
            hra = 0;
        }


        String Ta = editTextNumber1.getText().toString();
        int taxallowance;

        try
        {
            // the String to int conversion happens here
            taxallowance = Integer.parseInt(Ta.trim());

        }
        catch (NumberFormatException nfe)
        {
            taxallowance = 0;
        }

        String nTa = editTextNumber1.getText().toString();
        int nontaxallowance;

        try
        {
            // the String to int conversion happens here
            nontaxallowance = Integer.parseInt(nTa.trim());

        }
        catch (NumberFormatException nfe)
        {
            nontaxallowance = 0;
        }


        int p = basic + taxallowance;
        int q = p +nontaxallowance+hra;
        String old1 = String.valueOf(calculate_old(q));
        String old2 = String.valueOf(calculate_old(p));


        String new1 = String.valueOf(calculate_new(q));
        String new2 = String.valueOf(calculate_new(p));

        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("old_1","Total tax deduction will be "+old1);
        intent.putExtra("old_2","Minimum tax deduction will be "+ old2 +" after considering MAX tax exemption in HRA and allowance");

        intent.putExtra("new_1", "Total tax deduction will be "+new1);
        intent.putExtra("new_2","Minimum tax deduction will be "+ new2 +" after considering MAX tax exemption in HRA and allowance");

        startActivity(intent);


    }
}