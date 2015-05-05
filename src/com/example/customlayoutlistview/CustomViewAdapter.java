package com.example.customlayoutlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomViewAdapter extends BaseAdapter {
	
	private Context context;

	private ArrayList<String> list;
	
	public CustomViewAdapter(Context ctx, ArrayList<String> list) {
		this.context=ctx;
		this.list=list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return list.indexOf(list.get(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//get an instance of layout inflator
		LayoutInflater mInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		
		//inflate our view with the layout that we created earlier
		convertView=mInflater.inflate(R.layout.layout_custom_row, parent, false);
		
		//get the reference of textview from our inflated view
		TextView customTv=(TextView)convertView.findViewById(R.id.tv_custom);
		
		//set some text to it by taking it from list that we passed from activity
		customTv.setText((String)getItem(position));
		
		//return the view at the end
		return convertView;
	}
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

}
