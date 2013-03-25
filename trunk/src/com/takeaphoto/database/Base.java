package com.takeaphoto.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Base extends SQLiteOpenHelper {
	private static final String TABLE_DEMANDE = "table_demande";
	private static final String COL_ID = "ID";
	private static final String COL_LOGIN = "Login";
	private static final String COL_LAT = "Lat" ;
	private static final String COL_LNG = "Lng" ;
	private static final String COL_DESCRIPTION = "Description";
	private static final String COL_ETAT = "Etat" ;

	private static final String CREATE_BDD = "CREATE TABLE " + TABLE_DEMANDE + " ("
	+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_LOGIN + " TEXT NOT NULL, "
	+ COL_LAT + " REAL NOT NULL, " + COL_LNG + " REAL NOT NULL, " + COL_DESCRIPTION 
	+ " TEXT NOT NULL, " + COL_ETAT + " TEXT NOT NULL);";
 
	public Base(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		//on créé la table à partir de la requête écrite dans la variable CREATE_BDD
		db.execSQL(CREATE_BDD);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
		//comme ça lorsque je change la version les id repartent de 0
		db.execSQL("DROP TABLE " + TABLE_DEMANDE + ";");
		onCreate(db);
	}
}



