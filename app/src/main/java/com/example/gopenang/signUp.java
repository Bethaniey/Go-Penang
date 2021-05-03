package com.example.gopenang;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Password;
    private EditText PasswordConfirmation;
    private CheckBox Terms;
    private UserDatabaseHelper dbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Name = findViewById(R.id.etName);
        Email = findViewById(R.id.etEmailReg);
        Password = findViewById(R.id.etPasswordReg);
        PasswordConfirmation = findViewById(R.id.etPasswordReg2);
        Terms = findViewById(R.id.cbTerms);
        Button signup = findViewById(R.id.btnSignup2);
        Button login = findViewById(R.id.btnLogin3);
        dbUser = new UserDatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(signUp.this, logIn.class);
                startActivity(intent);
            }
        });

        //Insert database here
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Terms.isChecked()) {
                    String name = Name.getText().toString();
                    String email = Email.getText().toString();
                    String password = Password.getText().toString();
                    String passwordConfirmation = PasswordConfirmation.getText().toString();

                    if(name.equals("") || password.equals("") || passwordConfirmation.equals("")) {
                        Toast.makeText(signUp.this, "Please enter the required field(s)", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (password.equals(passwordConfirmation)) {
                            //Check user exist or not
                            Boolean checkUser = dbUser.checkUser(email);

                            if(!checkUser) {
                                Boolean insert = dbUser.insertData(email, name, password);

                                if(insert) {
                                    Toast.makeText(signUp.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), bottomNavi.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(signUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(signUp.this, "Email already registered. Please log in.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(signUp.this, "Password not matched.", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(signUp.this, "Please read and check the terms of service", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}