package com.example.gopenang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;

public class logIn extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private int counter = 3;
    private UserDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        Button login = findViewById(R.id.btnLogin2);
        Button signup = findViewById(R.id.btnSignup3);
        Button forgotPw = findViewById(R.id.btnForgotPw);
        CheckBox rememberMe = findViewById(R.id.cbRemember);
        db = new UserDatabaseHelper(this);

        //Share the value of REMEMBER ME upon user log in
        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");

        //If checked, user no need to log in again next time unless is logged out
        if(checkbox.equals("true")) {
            Intent intent = new Intent(logIn.this, bottomNavi.class);
            startActivity(intent);
            finish();
        }
        else if (checkbox.equals("false")) {
            Toast.makeText(this, "Please log in.", Toast.LENGTH_SHORT).show();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                //Share the value of email for user profile updates in other activities
                SharedPreferences.Editor editor = getSharedPreferences(EMAIL, MODE_PRIVATE).edit();
                editor.putString("email", email);
                editor.apply();

                if (email.equals("") || password.equals(""))
                    Toast.makeText(logIn.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkEmailPass = db.checkPassword(email, password);
                    if (checkEmailPass) {
                        Toast.makeText(logIn.this, "WELCOME", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent (getApplicationContext(), bottomNavi.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(logIn.this, "Invalid log in! Your email or password is incorrect.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(compoundButton.isChecked()) {
                    //Setting the shared value -- "remember"
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                }
                else if (!compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                }
            }
        });

        forgotPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent (logIn.this, forgotPw.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (logIn.this, signUp.class);
                startActivity(intent);
            }
        });
    }
}