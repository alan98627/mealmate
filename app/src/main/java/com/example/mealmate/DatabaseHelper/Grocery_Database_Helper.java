package com.example.mealmate.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import com.example.mealmate.Model.Grocery;

import java.util.ArrayList;
import java.util.List;

public class Grocery_Database_Helper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ITEMS_INFO_DB";
    public static final String TABLE_NAME = "ITEMS_INFO_TABLE";
    public static final int DB_VERSION = 2;

    // Table columns
    public static final String COLUMN_ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE_URI = "image_uri";
    public static final String IMAGE_PATH = "image_path";
    public static final String PURCHASED = "purchased";
    public static final String LOCATION = "location";

    public Grocery_Database_Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " TEXT PRIMARY KEY, " +
                NAME + " TEXT NOT NULL, " +
                PRICE + " REAL NOT NULL, " +
                DESCRIPTION + " TEXT, " +
                IMAGE_URI + " TEXT, " +
                IMAGE_PATH + " TEXT, " +
                LOCATION + " TEXT, " +
                PURCHASED + " INTEGER)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + LOCATION + " TEXT");
            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + IMAGE_PATH + " TEXT");
        }
    }

    public List<Grocery> getAllGroceries() {
        List<Grocery> groceryList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                Grocery grocery = new Grocery(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(3),
                        cursor.getDouble(2),
                        cursor.getString(4) != null ? Uri.parse(cursor.getString(4)) : null,
                        cursor.getInt(6) == 1,
                        cursor.getString(7),
                        cursor.getString(5)
                );
                groceryList.add(grocery);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return groceryList;
    }
}
