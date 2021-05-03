package com.example.gopenang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;

public class editProfile extends AppCompatActivity {

    private EditText newName;
    private UserDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        newName = findViewById(R.id.etEditName);
        Button updateProfile = findViewById(R.id.btnUpdateProfile);
        Button changePw = findViewById(R.id.btnChgePw);
        db = new UserDatabaseHelper(this);

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_name = newName.getText().toString();
                SharedPreferences preferencesEmail = getSharedPreferences(EMAIL, MODE_PRIVATE);
                String email = preferencesEmail.getString("email", "");

                Boolean updateName = db.updateProfile (email, new_name);

                if(updateName) {
                    Toast.makeText(editProfile.this, "Profile updated.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(editProfile.this, "Failed to update profile. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        changePw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (editProfile.this, changePassword.class);
                startActivity(intent);
            }
        });
    }
}