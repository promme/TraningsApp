package com.example.schema.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schema.model.Excercise;
import com.example.schema.model.Scheme;

public class ExcerciseAdapter extends BaseAdapter {

	private ArrayList<Excercise> allExcercises;
	private Context context;

	public ExcerciseAdapter(Context context, ArrayList<Excercise> excercises) {
		this.allExcercises = excercises;
		this.context = context;
	}

	@Override
	public int getCount() {
		return allExcercises.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Excercise excercise = allExcercises.get(position);
		TextView tv = new TextView(context);
		tv.setTextColor(Color.GREEN);
		tv.setBackgroundColor(Color.BLUE);
		tv.setTextSize(22);
		tv.setText(excercise.getMuscleGroup());
		return tv;

	}

}
