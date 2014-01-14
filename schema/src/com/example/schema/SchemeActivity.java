package com.example.schema;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schema.adapter.SchemeAdapter;
import com.example.schema.database.DatabaseHandler;
import com.example.schema.model.Scheme;

public class SchemeActivity extends Activity {

	private ArrayList<Scheme> allSchemes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);

		ListView listView = (ListView) findViewById(R.id.list_view);

		DatabaseHandler databaseHandller = new DatabaseHandler(this);
		databaseHandller.open();
		allSchemes = databaseHandller.getAllSchemes();

		SchemeAdapter adapter = new SchemeAdapter(this, allSchemes);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(onSchemeClickListener);

		// for(int i = 0; i < allSchemes.size(); i++){
		// Scheme scheme = allSchemes.get(i);
		// Log.d("test", "found scheme" + scheme.getTitle());
		// }
		databaseHandller.close();
	}

	OnItemClickListener onSchemeClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
			Scheme scheme = allSchemes.get(position);
			Toast.makeText(getBaseContext(), "Clicked : " + scheme.getTitle(),Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(getBaseContext(), ExcerciseActivity.class);
			intent.putExtra("ID", scheme.getId());
			startActivity(intent);
		}
	};
}
