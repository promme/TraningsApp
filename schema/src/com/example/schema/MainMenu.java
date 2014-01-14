package com.example.schema;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity implements OnClickListener {

	Button Scheme, Calender, VadNuDeSistaVa, HandleSchemes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		Scheme = (Button) findViewById(R.id.bScheme);
		Calender = (Button) findViewById(R.id.bCalender);
		VadNuDeSistaVa = (Button) findViewById(R.id.bVadNuDenSistaHeter);
		HandleSchemes = (Button) findViewById(R.id.bHandleSchemes);

		Scheme.setOnClickListener(this);
		Calender.setOnClickListener(this);
		VadNuDeSistaVa.setOnClickListener(this);
		HandleSchemes.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bScheme:

			Intent i1 = new Intent(this, MainActivity.class);

			startActivity(i1);
			break;
		case R.id.bCalender:

			Intent i2 = new Intent(this, AndroidGridLayoutActivity.class);

			startActivity(i2);
			break;

		case R.id.bHandleSchemes:

			Intent i3 = new Intent(this, SchemeActivity.class);

			startActivity(i3);
			break;
			// case R.id.bVadNuDenSistaHeter:
			//
			// Intent i3 = new Intent(this, SQLView.class);
			//
			// startActivity(i3);
			// break;
		}
	}
}