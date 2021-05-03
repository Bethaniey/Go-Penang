package com.example.gopenang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "myUser.db";

    public UserDatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create TABLE USER_PROFILE(email TEXT primary key, name TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("DROP TABLE IF EXISTS USER_PROFILE");
    }

    public Boolean insertData(String email, String name, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValuesUser = new ContentValues();
        contentValuesUser.put("email", email);
        contentValuesUser.put("name", name);
        contentValuesUser.put("password", password);
        long result = myDB.insert("user_profile", null, contentValuesUser);

        if (result == 1)
            return false;
        else
            return true;
    }

    public boolean deleteAccount(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("user_profile", "email =?", new String[]{email}) > 0;
    }

    public Boolean checkUser(String email) {
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT  * FROM user_profile WHERE email = ?", new String[]{email});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkPassword(String email, String password) {
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM user_profile WHERE email = ? " +
                "AND password = ?", new String[]{email, password});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean updatePassword(String email, String newPassword) {

        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", newPassword);
        long result = myDB.update("user_profile", contentValues, "email = ?", new String[]{email});

        if (result == 1)
            return true;
        else
            return false;
    }

    public Boolean updateProfile(String email, String newName) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", newName);

        long result = myDB.update("user_profile", contentValues, "email = ?", new String[]{email});

        if (result == 1)
        {
            return true;
        }
        else
            return false;
    }

    //Query user's name for displaying
    public Cursor fetchName (String email) {

        SQLiteDatabase myDB = this.getReadableDatabase();

        Cursor cursor = myDB.rawQuery("SELECT name FROM user_profile WHERE email = ?", new String[]{email});

        return cursor;
    }
}
