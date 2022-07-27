package com.example.onlineshopping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    // Database Name
    private static final String DATABASE_NAME = "Userdata";
    // User table name
    private static final String TABLE_USER = "user_table";
    // User Table Columns names
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_NAME = "name";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " ("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_EMAIL + " TEXT,"
                +  COLUMN_USER_PASSWORD + " TEXT)";

        sqLiteDatabase.execSQL(CREATE_USER_TABLE);

    }



    public void addUser(String name,String email,String pswd ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME,name);
        values.put(COLUMN_USER_EMAIL,email);
        values.put(COLUMN_USER_PASSWORD,pswd);
        // Inserting, Row
        db.insert(TABLE_USER,null, values);
        db.close();
    }


    public boolean checkUser(String email,String password) {
// array of columns to fetch
        String[] columns = {
                COLUMN_USER_EMAIL
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ? " + "AND " + COLUMN_USER_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        return cursorCount > 0;
    }

    public boolean checkUser(String em ) {
// array of columns to fetch
        SQLiteDatabase db1 = this.getReadableDatabase();
        String[] columns1 = { COLUMN_USER_EMAIL };
        String limit="1";

        // selection criteria
        String selection1 = COLUMN_USER_EMAIL + " =? ";
        String[] selectionArgs1 = {em};
        Cursor cursor1 = db1.query(TABLE_USER, columns1, selection1, selectionArgs1, null, null, null,limit);
        boolean exists = (cursor1.getCount()>0);
        cursor1.close();
        return exists;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int x) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);

    }

}




