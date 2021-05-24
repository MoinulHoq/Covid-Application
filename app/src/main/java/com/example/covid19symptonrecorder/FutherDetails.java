package com.example.covid19symptonrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FutherDetails extends AppCompatActivity {


    Button finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futher_details);


        finished = findViewById(R.id.NextP);
        finished.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent BackToMain = new Intent( FutherDetails.this, HomeScreen.class);
                startActivity(BackToMain);

            }
        }));
    }
}