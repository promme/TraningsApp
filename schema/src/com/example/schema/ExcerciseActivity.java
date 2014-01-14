package com.example.schema;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.schema.adapter.ExcerciseAdapter;
import com.example.schema.database.DatabaseHandler;
import com.example.schema.model.Excercise;

public class ExcerciseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_excercise);

		final ListView listView = (ListView) findViewById(R.id.ex_listview);
		final LinearLayout contentLayout = (LinearLayout) findViewById(R.id.excercise_add_view_layout);
		
		Button hideOrShowButton = (Button) findViewById(R.id.hide_or_show_button);
		hideOrShowButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(listView.isShown()){
					listView.setVisibility(View.GONE);
					contentLayout.setVisibility(View.VISIBLE);
				}else{
					listView.setVisibility(View.VISIBLE);
					contentLayout.setVisibility(View.GONE);
				}
				
			}
		});
		
		//Hämta ID från förra activityn
		int id = getIntent().getExtras().getInt("ID");
		
		DatabaseHandler dbHandler = new DatabaseHandler(this);
		dbHandler.open();
		
		Excercise fake = new Excercise();
		fake.setTitle("Armar");
		fake.setId(id);
		fake.setMuscleGroup("Runk muskeln");
		fake.setNumberOfRepititions(10);
		fake.setNumberOfSets(10);
		fake.setTrainingType("okkk");
		fake.setExcersiseName("excerciseNamn");
		
		dbHandler.insertExcerciseIntoDatabase(fake);
		dbHandler.insertExcerciseIntoDatabase(fake);
		dbHandler.insertExcerciseIntoDatabase(fake);
		dbHandler.insertExcerciseIntoDatabase(fake);
		
		ArrayList<Excercise> allExcercies = dbHandler.getAllExcercises(id);
		ExcerciseAdapter adapter = new ExcerciseAdapter(this, allExcercies);
		listView.setAdapter(adapter);
	
	}
	
	
}
