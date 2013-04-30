package com.example.distribuidora;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

	 public AdminSQLiteOpenHelper(Context context, String nombre, CursorFactory factory, int version) {
	        super(context, nombre, factory, version);
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        db.execSQL("create table distribuidora(_id integer primary key, modelo text, color text)");
	    }

	    @Override
	    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
	        db.execSQL("drop table if exists distribuidora");
	        db.execSQL("create table distribuidora(_id integer primary key, modelo text, color text)");        
	    }   

}
