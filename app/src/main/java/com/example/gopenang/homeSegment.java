package com.example.gopenang;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class homeSegment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.segment_home, container, false);

        ImageButton catPenang = (ImageButton) view.findViewById(R.id.catPenang);
        ImageButton catFood = (ImageButton) view.findViewById(R.id.catFood);
        ImageButton catPlaces = (ImageButton) view.findViewById(R.id.catPlaces);
        TextView penangText = (TextView) view.findViewById(R.id.catPenang_text);
        TextView foodText = (TextView) view.findViewById(R.id.catFood_text);
        TextView placesText = (TextView) view.findViewById(R.id.catPlaces_text);

        catPenang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutPenang.class);
                startActivity(intent);
            }
        });

        penangText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutPenang.class);
                startActivity(intent);
            }
        });

        catFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutFood.class);
                startActivity(intent);
            }
        });

        foodText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutFood.class);
                startActivity(intent);
            }
        });

        catPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutPlaces.class);
                startActivity(intent);
            }
        });

        placesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutPlaces.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
