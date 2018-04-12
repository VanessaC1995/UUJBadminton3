package com.example.vanessa.uujbadminton;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Vanessa.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //private static final int DATABASE_VERSION = 2;

    //private Context con;

    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
       // con=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(name text primary key, password text)");

        //String createTable="create table Progress (xValues INTEGER, yValues INTEGER);";
        //db.execSQL(createTable);
        //Toast.makeText(con, "Table Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
       // db.execSQL("drop table if exists Progress");
    }

    /*public void insertData(int x, int y)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put("xValues", x);
        values.put("yValues", y);

        long ins = db.insert("Progress", null, values);
        Toast.makeText(con, "Data Inserted", Toast.LENGTH_SHORT).show();
    }*/

    //inserting into database
    public boolean insert(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", username);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }
    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where name =?", new String[]{username});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    //checking the username and password
    public Boolean usernamepassword(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where name=? and password =?", new String[]{username, password});
        if(cursor.getCount()>0) return true;
        else return false;

    }



}


