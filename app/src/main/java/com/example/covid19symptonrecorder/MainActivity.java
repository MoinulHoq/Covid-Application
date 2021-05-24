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

import com.example.covid19symptonrecorder.ui.UserHelperClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText emailID, password, UFirstName, ULastName, UDateOfBirth, UGender,UPhoneNumber;
     Button BSignUp;
     TextView TSignIn;
     FirebaseAuth mFirebaseAuth;
     FirebaseDatabase rootNode;
     DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth =FirebaseAuth.getInstance();
        emailID=findViewById(R.id.EmailAddress2);
        UFirstName=findViewById(R.id.UFirstName);
        ULastName =findViewById(R.id.ULastName);
        UDateOfBirth=findViewById(R.id.UDateOfBirth);
        UGender=findViewById(R.id.UGender2);
        UPhoneNumber=findViewById(R.id.PhoneNumber);







        password=findViewById(R.id.Password2);
        BSignUp= findViewById(R.id.buttonUp);
        TSignIn=findViewById(R.id.TextSignIn);
        BSignUp.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(MainActivity.this,"All fields are Empty!!",Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty()&& pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {


                        @Override
                        public void onComplete(@NonNull Task task) {
                           if(!(task.isSuccessful())){
                               Toast.makeText(MainActivity.this,"Sign Up Unsuccessful",Toast.LENGTH_SHORT).show();
                           }
                           else{

                                   rootNode=FirebaseDatabase.getInstance();
                                   reference=rootNode.getReference("Users");



                                   // Get all the Values for Registration Form

                               String emailI = emailID.getEditableText().toString();
                               String FirstName= UFirstName.getEditableText().toString();
                               String LastName = ULastName.getEditableText().toString();
                               String DateOfBirth = UDateOfBirth.getEditableText().toString();
                               String Gender = UGender.getEditableText().toString();
                               String PhoneNo=UPhoneNumber.getEditableText().toString();






                               UserHelperClass helperClass= new UserHelperClass( emailI, FirstName, LastName, DateOfBirth, Gender,PhoneNo);


                                reference.child(PhoneNo).setValue(helperClass);




                                   Toast.makeText(MainActivity.this,"Sign Up Successful",Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(MainActivity.this,HomeScreen.class));


                           }
                        }
                    });
                }
                else{

                    Toast.makeText(MainActivity.this,"Please try Again ",Toast.LENGTH_SHORT).show();


                }
            }
        });
        TSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this,ActivityLogin.class);
                startActivity(i);
            }
        });
    }

}
