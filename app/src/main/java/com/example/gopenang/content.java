package com.example.gopenang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class content extends AppCompatActivity {

    private TextView pageCurrent;
    private ImageView image;
    private TextView travelName;
    private TextView travelDescription;
    private TextView operatingHour;
    private TextView address;
    private Button maps;
    private ImageButton previousPage, nextPage;

    private List<contentDeclare> travelContentList;
    private int contentCounter = 0;
    private int contentCountTotal;
    private contentDeclare travelContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        String chosenCategory = intent.getStringExtra("category");

        pageCurrent = findViewById(R.id.pageCurrent);
        image = findViewById(R.id.ivContent);
        travelName = findViewById(R.id.tvTravelName);
        travelDescription = findViewById(R.id.tvTravelDescription);
        operatingHour = findViewById(R.id.tvOperatingHour);
        address = findViewById(R.id.tvAddress);
        maps = findViewById(R.id.btnMap);
        previousPage = findViewById(R.id.btnPrevious);
        nextPage = findViewById(R.id.btnNext);

        DbAccessHelper dbAccessHelper = DbAccessHelper.getInstance(this);
        dbAccessHelper.openDatabase();

        travelContentList = dbAccessHelper.getTravelContent(chosenCategory);
        contentCountTotal = travelContentList.size();

        showNextContent();

        dbAccessHelper.closeDatabase();

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://maps.google.com.my/"));
                startActivity(Intent.createChooser(intent, "Map"));
            }
        });

        previousPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentCounter--;
                showNextContent();
            }
        });

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentCounter++;
                showNextContent();
            }
        });
    }

    public void showNextContent() {

        nextPage.setEnabled(true);
        previousPage.setEnabled(true);

        if (contentCounter < contentCountTotal) {
            travelContent = travelContentList.get(contentCounter);

            pageCurrent.setText(Integer.toString(contentCounter + 1));
            image.setImageBitmap(travelContent.getImage());
            travelName.setText(travelContent.getName());
            travelDescription.setText(travelContent.getDescription());
            operatingHour.setText(travelContent.getOperatingHour());
            address.setText(travelContent.getAddress());

            if (contentCounter != 0) {
                previousPage.setEnabled(true);
            } else {
                previousPage.setEnabled(false);
            }

            if (contentCounter != 9) {
                nextPage.setEnabled(true);
            } else {
                nextPage.setEnabled(false);
            }
        }
    }
}