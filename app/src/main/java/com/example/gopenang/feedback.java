package com.example.gopenang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class feedback extends AppCompatActivity {

    private Button submit;
    private EditText feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        submit =findViewById(R.id.btnSubmitFb);
        feedback = findViewById(R.id.etFeedback);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(feedback.this, "Thank you for contacting us", Toast.LENGTH_SHORT).show();
                feedback.setText("Type your feedback here");
            }
        });
    }
}