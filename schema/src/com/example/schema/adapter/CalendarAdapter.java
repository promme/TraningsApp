package com.example.schema.adapter;

import com.example.schema.R;
import com.example.schema.R.drawable;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CalendarAdapter extends BaseAdapter {
	private Context mContext;

	// Keep all Images in array
	public Integer[] mThumbIds = { R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum, R.drawable.datum, R.drawable.datum,
			R.drawable.datum,

	};

	// Constructor
	public CalendarAdapter(Context c) {
		mContext = c;
	}

	@Override
	public int getCount() {
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		return mThumbIds[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(mContext);
		imageView.setImageResource(mThumbIds[position]);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
		return imageView;
	}

}