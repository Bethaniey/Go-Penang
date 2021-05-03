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

public class placesSegment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.segment_places, container, false);

        ImageButton aboutPlaces = (ImageButton) view.findViewById(R.id.about_places);
        ImageButton heritagePlaces = (ImageButton) view.findViewById(R.id.heritage_places);
        ImageButton funLeisurePlaces = (ImageButton) view.findViewById(R.id.funLeisure_places);
        TextView aboutPlacesText = (TextView) view.findViewById(R.id.aboutPlaces_text);
        TextView heritageText = (TextView) view.findViewById(R.id.heritage_text);
        TextView funLeisureText = (TextView) view.findViewById(R.id.funLeisure_text);

        aboutPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutPlaces.class);
                startActivity(intent);
            }
        });

        aboutPlacesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutPlaces.class);
                startActivity(intent);
            }
        });

        heritagePlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = getActivity().getIntent().getStringExtra("category");
                intoContent("Heritage");
            }
        });

        heritageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = getActivity().getIntent().getStringExtra("category");
                intoContent("Heritage");
            }
        });

        funLeisurePlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = getActivity().getIntent().getStringExtra("category");
                intoContent("Fun");
            }
        });

        funLeisureText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = getActivity().getIntent().getStringExtra("category");
                intoContent("Fun");
            }
        });
        return view;
    }
    public void intoContent(String category)
    {
        Intent intent = new Intent (getActivity(), content.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}