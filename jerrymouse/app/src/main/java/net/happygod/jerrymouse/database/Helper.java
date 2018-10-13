package net.happygod.jerrymouse.database;

import android.content.*;
import android.database.sqlite.*;

class Helper extends SQLiteOpenHelper
{
	private final static Integer version = 1;
	Helper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version)
	{
		super(context,name,factory,version);
	}
	Helper(Context context,String name,int version)
	{
		this(context,name,null,version);
	}
	Helper(Context context,String name)
	{
		this(context, name, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		System.out.println("create database");
		String sql="CREATE TABLE general(id INTEGER PRIMARY KEY AUTOINCREMENT,enabled BOOLEAN NOT NULL DEFAULT FALSE,port INTEGER DEFAULT NULL,webroot VARCHAR(256) DEFAULT NULL,proxymode BOOLEAN NOT NULL DEFAULT FALSE,allowindex BOOLEAN NOT NULL DEFAULT FALSE,servletvisible BOOLEAN NOT NULL DEFAULT FALSE);";
		//ONLY database jerrymouse shall do it
		db.execSQL(sql);
		sql="INSERT INTO general VALUES(0,1,8080,'/storage/emulated/0/web',0,1,1),(1,1,8000,null,1,0,0),(2,1,8010,'localhost:8000',1,0,0),(3,1,8020,'localhost:8080',1,0,0);";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		System.out.println("update to: "+newVersion);
	}
}