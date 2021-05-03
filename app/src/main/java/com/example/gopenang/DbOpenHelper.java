package com.example.gopenang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DbOpenHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "travel_info.db";
    private static final int DATABASE_VERSION = 1;


    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME,  null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
