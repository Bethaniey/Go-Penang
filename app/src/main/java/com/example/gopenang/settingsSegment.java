package com.example.gopenang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.ContactsContract.Intents.Insert.EMAIL;

public class settingsSegment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.segment_settings, container, false);

        TextView profileName = (TextView) view.findViewById(R.id.tvName);
        TextView profileEmail = (TextView) view.findViewById(R.id.tvEmail);
        Button editProfile = view.findViewById(R.id.btnEditProfile);
        Button help = (Button) view.findViewById(R.id.btnHelp);
        Button terms = (Button) view.findViewById(R.id.btnTerms);
        Button logout = (Button) view.findViewById(R.id.btnLogout);
        Button deleteAccount = (Button) view.findViewById(R.id.btnDelAcc);

        UserDatabaseHelper dbUser = new UserDatabaseHelper(getActivity());

        SharedPreferences preferencesEmail = getActivity().getSharedPreferences(EMAIL, MODE_PRIVATE);
        String email = preferencesEmail.getString("email", "");
        Cursor cursor = dbUser.fetchName(email);

        if( cursor.getCount() >= 1) {
            while(cursor.moveToNext() ) {
                profileName.setText(cursor.getString(0));
                profileEmail.setText(email);
            }
            cursor.close();
        }

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), editProfile.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), feedback.class);
                startActivity(intent);
            }
        });

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), termsPolicy.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getActivity().getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();

                Intent intent = new Intent (getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), delacc.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
