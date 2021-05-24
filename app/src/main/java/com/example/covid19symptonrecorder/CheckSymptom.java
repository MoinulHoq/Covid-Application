package com.example.covid19symptonrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid19symptonrecorder.ui.UserHelperClass;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CheckSymptom extends AppCompatActivity {





   EditText Descriptiond,Dayd;
   Button NextB ;


    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_symptom);






        Descriptiond=findViewById(R.id.Description);
        Dayd=findViewById(R.id.Day);





            NextB = findViewById(R.id.NextP);
            NextB.setOnClickListener((new View.OnClickListener() {




                @Override
                public void onClick(View v)


                {

                    rootNode=FirebaseDatabase.getInstance();
                    reference=rootNode.getReference("UserSymstoms");



                    // Get all the Values for Registration Form

                    String NumberofDay = Dayd.getEditableText().toString();
                    String Description= Descriptiond.getEditableText().toString();
                    






                    UserHelperClass helperClass= new UserHelperClass( Description,NumberofDay);


                    reference.child(NumberofDay).setValue(helperClass);




                    Toast.makeText(CheckSymptom.this,"Data Added",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CheckSymptom.this,FutherDetails.class));















                   // Intent NextForm = new Intent( CheckSymptom.this, FutherDetails.class);
                  //  startActivity(NextForm );

                }
            }));
        }



    }
