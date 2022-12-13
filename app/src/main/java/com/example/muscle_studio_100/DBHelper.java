package com.example.muscle_studio_100;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{

   /* public static final String DBName = "Login.db";
    public static final String TableName = "users";
    public static final String UserName = "usersname";
    public static final String Password = "password";
*/

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase MonBDD) {
        String query = "CREATE TABLE users(username TEXT primary key , password TEXT )";
        MonBDD.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MonBDD, int OldVersion, int NewVersion) {
        MonBDD.execSQL("DROP TABLE if exists users");
    }

    public Boolean insertData(String username , String password){
        SQLiteDatabase MonBDD = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username" , username);
        cv.put("password",password);
        long result = MonBDD.insert("users",null , cv);
        return result != -1;

    }
    //Fonction qui modifier les données de la bdd
    public Boolean updatePass(String user , String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("password",pass);
        long result = db.update("users",cv , "username=?",new String[]{user});
        return result != -1;
    }
    //Fonction qui modifier les données de la bdd
    public Boolean updateUser(String user , String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username" , user);

        long result = db.update("users",cv , "password=?",new String[]{pass});
        return result != -1;
    }

    //fonction qui verifie si l'utilisateur existe deja ou pas
    public Boolean checkusername(String username){
        SQLiteDatabase MonBDD = this.getWritableDatabase();
        Cursor cursor = MonBDD.rawQuery("SELECT * FROM users WHERE username = ?",new String[] {username});
        if(cursor.getCount() > 0) return true ;
        else return false ;

    }
    //fonction qui verifie si un compte existe deja ou pas
    public Boolean checkUsernamePassword(String username , String password)
    {
        SQLiteDatabase myDB= this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?",new String[] {username , password});

        if(cursor.getCount() > 0 ) return true ;
        else return false ;
    }


}
