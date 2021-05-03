package com.example.gopenang;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class aboutPenang extends AppCompatActivity {

    private VideoView video;
    private android.net.Uri Uri;
    private MediaController MediaController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutpenang);

        VideoView videoView = findViewById(R.id.videoView);

        String videoPath ="android.resource://" +getPackageName() + "/" + R.raw.penang_intro;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
