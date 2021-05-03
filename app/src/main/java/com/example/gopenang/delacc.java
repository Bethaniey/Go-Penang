package com.example.gopenang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;

public class delacc extends AppCompatActivity {

    private UserDatabaseHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new UserDatabaseHelper(this);

        SharedPreferences preferencesEmail = getSharedPreferences(EMAIL, MODE_PRIVATE);
        String email = preferencesEmail.getString("email", "");

        Boolean deleteAccount = db.deleteAccount (email);

        if(deleteAccount) {
            Toast.makeText(delacc.this, "Profile deleted.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (delacc.this, signUp.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(delacc.this, "Failed to delete profile. ", Toast.LENGTH_SHORT).show();
        }
    }
}
