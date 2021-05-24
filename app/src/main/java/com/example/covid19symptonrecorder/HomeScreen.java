package com.example.covid19symptonrecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private CardView compareS, healthService, emergency, checkYourS, healthTopic, medicine;
   Button logoutB;

    //FirebaseAuth mFirebaseAuth;
    //private FirebaseAuth.AuthStateListener mAuthStateListener;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Defining car view
        setContentView(R.layout.activity_home_screen);

        compareS = (CardView) findViewById(R.id.CompareSymptom);
        healthService = (CardView) findViewById(R.id.findSer);
        emergency = (CardView) findViewById(R.id.callE);
        healthTopic = (CardView) findViewById(R.id.healthT);
        medicine = (CardView) findViewById(R.id.medicine);
        checkYourS = (CardView) findViewById(R.id.checksy);

        // adding on click listeners  to the card

        compareS.setOnClickListener(this);
        healthService.setOnClickListener(this);
        emergency.setOnClickListener(this);
        healthTopic.setOnClickListener(this);
        medicine.setOnClickListener(this);
        checkYourS.setOnClickListener(this);

        // coming back to Login  screen
         logoutB = findViewById(R.id.logout);
        logoutB.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent BackToMain = new Intent(HomeScreen.this, ActivityLogin.class);
                startActivity(BackToMain);

            }
        }));

    }
    @Override
    public void onClick(View v) {
        Intent selectDash;
        switch (v.getId()){

            case R.id.CompareSymptom : selectDash =new Intent(this,CompareCovid.class);startActivity(selectDash); break;
            case R.id.findSer :selectDash = new Intent(this,HealthServices.class);startActivity(selectDash); break;
            case R.id.callE :selectDash = new Intent(this,Emergency.class); startActivity(selectDash);break;
            case R.id.healthT :selectDash = new Intent(this,HealthTopic.class); startActivity(selectDash); break;
            case R.id.medicine :selectDash = new Intent(this,Medicines.class);startActivity(selectDash);  break;
            case R.id.checksy :selectDash = new Intent(this,CheckSymptom.class);startActivity(selectDash); break;

            default:break;







        }



    }


}







