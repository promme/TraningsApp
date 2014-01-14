package com.example.schema;

import com.example.schema.database.DatabaseHandler;
import com.example.schema.model.Scheme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button SQLupdate, SQLview;
	TextView schemeTitleEditText, scgeneExcerciseEditText, SQLsets, SQLreps;
	Spinner muscleGroupSpinner;
	final String[] muscleGroups = { "Arm", "Ben" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SQLupdate = (Button) findViewById(R.id.bSQLupdate);

		schemeTitleEditText = (EditText) findViewById(R.id.etSQLschemeName);
//		scgeneExcerciseEditText = (EditText) findViewById(R.id.etSQLExcercise);
//		SQLsets = (EditText) findViewById(R.id.etSQLSets);
//		SQLreps = (EditText) findViewById(R.id.etSQLReps);

//		muscleGroupSpinner = (Spinner) findViewById(R.id.muscleGroupSpinner);
//		muscleGroupSpinner.setAdapter(new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, muscleGroups));

		SQLupdate.setOnClickListener(this);


	}

	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bSQLupdate:
			try {

				String title = schemeTitleEditText.getText().toString();
//				String excercise = scgeneExcerciseEditText.getText().toString();
//				String sets = SQLsets.getText().toString();
//				String reps = SQLreps.getText().toString();
//				String trainingType = "MuscleGroup";

				DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);
				databaseHandler.open();

				Scheme test = new Scheme();
				test.setTitle(title);
				
				databaseHandler.insertSchemeIntoDatabase(test);
				
//				test.setExcersiseName(excercise);
//				test.setNumberOfRepititions(Integer.valueOf(sets));
//				test.setNumberOfSets(Integer.valueOf(reps));
//				test.setTrainingType(trainingType);
//				test.setMuscleGroup(trainingType);

//				databaseHandler.insertExcerciseIntoDatabase(test);
				databaseHandler.close();

				new AlertDialog.Builder(this)
				.setTitle("Message")
				.setMessage("Scheme created successfully!")
				.setNeutralButton("OK",
						new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog,int which) {
						dialog.dismiss();
//						Intent i = new Intent(getBaseContext(), SchemeActivity.class);
//						startActivity(i);
					}
				}).show();

				break;

			} catch (Exception e) {
				new AlertDialog.Builder(this)
				.setTitle("Error !")
				.setMessage("u did something wrong noob")
				.setNeutralButton("OK",
						new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog,
							int which) {
						dialog.dismiss();
					}
				}).show();
				break;
			} finally {
			}


		}
	}

}
