package com.example.schema.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schema.model.Scheme;

public class SchemeAdapter extends BaseAdapter {

	private ArrayList<Scheme> allSchemes;
	private Context context;

	public SchemeAdapter(Context context, ArrayList<Scheme> allSchemes) {
		this.allSchemes = allSchemes;
		this.context = context;
	}

	@Override
	public int getCount() {
		return allSchemes.size();
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
		Scheme scheme = allSchemes.get(position);
		TextView tv = new TextView(context);
		tv.setTextColor(Color.GREEN);
		tv.setBackgroundColor(Color.BLUE);
		tv.setTextSize(22);
		tv.setText(scheme.getTitle());
		return tv;

	}

}
