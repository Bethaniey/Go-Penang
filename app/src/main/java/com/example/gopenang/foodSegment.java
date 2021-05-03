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

public class foodSegment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.segment_food, container, false);

        ImageButton aboutFood = (ImageButton) view.findViewById(R.id.about_food);
        ImageButton hawkerFood = (ImageButton) view.findViewById(R.id.hawker_food);
        ImageButton restaurantFood = (ImageButton) view.findViewById(R.id.restaurant_food);
        TextView aboutFoodText = (TextView) view.findViewById(R.id.aboutFood_text);
        TextView hawkerText = (TextView) view.findViewById(R.id.hawker_text);
        TextView restaurantText = (TextView) view.findViewById(R.id.restaurant_text);

        aboutFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutFood.class);
                startActivity(intent);
            }
        });

        aboutFoodText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), aboutFood.class);
                startActivity(intent);
            }
        });

        hawkerFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = getActivity().getIntent().getStringExtra("category");
                intoContent("Hawker");
            }
        });

        hawkerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = getActivity().getIntent().getStringExtra("category");
                intoContent("Hawker");
            }
        });

        restaurantFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = getActivity().getIntent().getStringExtra("category");
                intoContent("Restaurant");
            }
        });

        restaurantText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = getActivity().getIntent().getStringExtra("category");
                intoContent("Restaurant");
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