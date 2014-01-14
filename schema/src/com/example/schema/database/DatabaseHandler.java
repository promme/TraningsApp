package com.example.schema.database;

import java.util.ArrayList;

import com.example.schema.model.Excercise;
import com.example.schema.model.Scheme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler {
	public static final String EXCERCISE_ID = "_id";
	public static final String EXCERCISE_TITLE = "excercise_title";
	public static final String EXCERISE_REPITITIONS = "excercise_repitition";
	public static final String EXCERCISE_TRAINING_TYPE = "excercise_traning_type";
	public static final String EXCERISE_SETS = "excercise_sets";
	public static final String EXCERCISE_NAME = "excercise_name";
	public static final String EXCERISE_MUSCLEGROUP = "excersise_muscle_group";
	private static final String EXCERCISE_TABLE = "excercise_table";

	
	private static final String SCHEME_TABLE = "scheme_table";
	public static final String SCHEME_TITLE = "scheme_title";
	public static final String SCHEME_ID = "scheme_id";

	private static final String DATABASE_NAME = "schemeDb";
	private static final int DATABASE_VERSION = 1;

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.d("db", "At the creation of dbHelper");
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + EXCERCISE_TABLE + " (" +
		EXCERCISE_ID + " INTEGER, " +
		EXCERCISE_TITLE + " TEXT NOT NULL, " + 
		EXCERCISE_NAME + " TEXT NOT NULL, " + 
		EXCERISE_MUSCLEGROUP + " TEXT NOT NULL, " + 
		EXCERISE_SETS + " INTEGER, " + 
		EXCERISE_REPITITIONS + " INTEGER, " + 
		EXCERCISE_TRAINING_TYPE + " TEXT NOT NULL);");
		
		db.execSQL("CREATE TABLE " + SCHEME_TABLE + " (" +
		SCHEME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		SCHEME_TITLE + " TEXT NOT NULL);");

		Log.d("db", "onCreate of the db");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + EXCERCISE_TABLE);
			onCreate(db);
		}

	}

	public DatabaseHandler(Context c) {
		ourContext = c;
		Log.d("db", "at the constructor");
	}

	public DatabaseHandler open() throws SQLiteException {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		ourHelper.close();

	}

	public void insertSchemeIntoDatabase(Scheme scheme) throws SQLiteException {
		ContentValues cv = new ContentValues();
		cv.put(SCHEME_TITLE, scheme.getTitle());
		ourDatabase.insert(SCHEME_TABLE, null, cv);
	}
	
	public ArrayList<Scheme> getAllSchemes(){
		String[] columns = new String[] { SCHEME_ID, SCHEME_TITLE };
		Cursor c = ourDatabase.query(SCHEME_TABLE, columns, null, null, null, null, null);
		int iID = 	c.getColumnIndex(SCHEME_ID);
		int iTitle = c.getColumnIndex(SCHEME_TITLE);
		
		ArrayList<Scheme> allSchemes = new ArrayList<Scheme>();
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			Scheme scheme = new Scheme();
			scheme.setId(c.getInt(iID));
			scheme.setTitle(c.getString(iTitle));
			allSchemes.add(scheme);
		}
		return allSchemes;
	}
	
	public long insertExcerciseIntoDatabase(Excercise excersise) throws SQLiteException {
		ContentValues cv = new ContentValues();
		cv.put(EXCERCISE_ID, excersise.getId());
		cv.put(EXCERCISE_TITLE, excersise.getTitle());
		cv.put(EXCERISE_REPITITIONS, excersise.getNumberOfRepititions());
		cv.put(EXCERCISE_TRAINING_TYPE, excersise.getTrainingType());
		cv.put(EXCERISE_SETS, excersise.getNumberOfSets());
		cv.put(EXCERCISE_NAME, excersise.getExcerciseName());
		cv.put(EXCERISE_MUSCLEGROUP, excersise.getMuscleGroup());
		return ourDatabase.insert(EXCERCISE_TABLE, null, cv);
	}
	
	public ArrayList<Excercise> getAllExcercises(int id) {
		String[] columns = new String[] { EXCERCISE_ID, EXCERCISE_TITLE, EXCERISE_REPITITIONS, EXCERCISE_TRAINING_TYPE, EXCERISE_SETS, EXCERCISE_NAME, EXCERISE_MUSCLEGROUP };
		Cursor c = ourDatabase.query(EXCERCISE_TABLE, columns, EXCERCISE_ID + "=" + id, null, null, null, null);
		int iRow = 	c.getColumnIndex(EXCERCISE_ID);
		int iTitle= c.getColumnIndex(EXCERCISE_TITLE);
		int iRepetitions = c.getColumnIndex(EXCERISE_REPITITIONS);
		int iTraningType = c.getColumnIndex(EXCERCISE_TRAINING_TYPE);
		int iSet = c.getColumnIndex(EXCERISE_SETS);
		int iExcercise = c.getColumnIndex(EXCERCISE_NAME);
		int iMuscleGroup = c.getColumnIndex(EXCERISE_MUSCLEGROUP);
		
		ArrayList<Excercise> allSchemes = new ArrayList<Excercise>();
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			Excercise scheme = new Excercise();
			scheme.setId(c.getInt(iRow));
			scheme.setTitle(c.getString(iTitle));
			scheme.setNumberOfRepititions(c.getInt(iRepetitions));
			scheme.setTrainingType(c.getString(iTraningType));
			scheme.setNumberOfSets(c.getInt(iSet));
			scheme.setExcersiseName(c.getString(iExcercise));
			scheme.setMuscleGroup(c.getString(iMuscleGroup));
			
			allSchemes.add(scheme);
		}
		return allSchemes;
	}

}
