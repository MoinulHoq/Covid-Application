package com.example.covid19symptonrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityLogin extends AppCompatActivity {
    EditText emailID, password, FirstName, LastName, DateOfBirth;
    Button BSignIn;
     TextView TSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth =FirebaseAuth.getInstance();
        emailID=findViewById(R.id.EmailAddress2);
        password=findViewById(R.id.Password2);
        BSignIn= findViewById(R.id.buttonUp);
        TSignUp=findViewById(R.id.BTSignUp);


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(( mFirebaseUser) != null){
                    Toast.makeText(ActivityLogin.this,"You are Logged in SuccessFully!!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent (ActivityLogin.this,HomeScreen.class);
                startActivity(i);
                }
                else{
                    Toast.makeText(ActivityLogin.this,"Please Login!!",Toast.LENGTH_SHORT).show();
                }
            }
        };

        BSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailID.getText().toString();
                String pwd=password.getText().toString();
                if (email.isEmpty()){
                    emailID.setError("Please enter correct email id");
                    emailID.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("Please provide valid password");
                    password.requestFocus();
                }

                else if (email.isEmpty()&& pwd.isEmpty()){
                    Toast.makeText(ActivityLogin.this,"All fields are Empty!!",Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty()&& pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(ActivityLogin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(ActivityLogin.this,"Login Error !!",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intToHom= new Intent (ActivityLogin.this,HomeScreen.class);
                             startActivity(intToHom);
                            }
                        }
                    });

                }
                else{

                    Toast.makeText(ActivityLogin.this,"Please try Again ",Toast.LENGTH_SHORT).show();


                }
            }
        });
        TSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp= new Intent(ActivityLogin.this,MainActivity.class);
                startActivity(intSignUp);
            }
        });

    }
    @Override
 protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
 }



}