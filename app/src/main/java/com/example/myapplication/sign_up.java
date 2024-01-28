package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up extends AppCompatActivity {
    private EditText email;
    private EditText username;
    private EditText age;
    private EditText password;
    private Button projectx;
    private Button log_in;
    private FirebaseAuth mAuth;

    FirebaseDatabase database;
    DatabaseReference mDatabase;

    private ApplicationAccount user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.emailAddress);
        username = findViewById(R.id.username2);
        age = findViewById(R.id.age);
        password = findViewById(R.id.password2);
        projectx = findViewById(R.id.projectx);
        log_in = findViewById(R.id.log_in2);
        mAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Users");

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_up.this, log_in.class);
                startActivity(intent);
            }
        });
        projectx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email_txt = email.getText().toString();
                String password_txt = password.getText().toString();
                String age_txt = age.getText().toString();
                String username_txt = username.getText().toString();

                user = new ApplicationAccount(email_txt,username_txt,age_txt,password_txt);

                if (password_txt.length() >= 6) {
                    create_user(email_txt, password_txt);

                }
                else {
                    Toast.makeText(sign_up.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void create_user(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user1 = mAuth.getCurrentUser();
                            UpdateData(user1);
                    } else {
                            Toast.makeText(sign_up.this, "Authentication failed", Toast.LENGTH_LONG).show();
                        } }
                });
    }
    public void UpdateData(FirebaseUser currentUser){
        mDatabase.child(currentUser.getUid()).setValue(user);
        mDatabase.child(currentUser.getUid()).child("numOfParties").setValue(0);
        Intent i = new Intent(sign_up.this, MainActivity.class);
        startActivity(i);

    }
    }
