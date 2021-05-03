package com.example.gopenang;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbAccessHelper {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DbAccessHelper instance;

    DbAccessHelper(Context context) {
        this.openHelper = new DbOpenHelper(context);
    }

    public static DbAccessHelper getInstance(Context context) {

        if (instance == null) {
            instance = new DbAccessHelper(context);
        }
        return instance;
    }

    public void openDatabase() {

        this.db = openHelper.getWritableDatabase();
    }

    public void closeDatabase() {

        if (db != null) {
            db.close();
        }
    }

    public List<contentDeclare>  getTravelContent(String category) {

        List<contentDeclare> travelContentList = new ArrayList<>();

        db = openHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM travel_info WHERE category = ?", new String[]{category});

        if (cursor.moveToFirst()) {
            do {
                contentDeclare travelContent = new contentDeclare();
                travelContent.setImage(cursor.getBlob(1));
                travelContent.setName(cursor.getString(2));
                travelContent.setDescription(cursor.getString(3));
                travelContent.setOperatingHour(cursor.getString(4));
                travelContent.setAddress(cursor.getString(5));
                travelContentList.add(travelContent);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return travelContentList;
    }
}
