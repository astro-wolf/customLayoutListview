package com.example.customlayoutlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
		//create an instance of viewholder class
		ViewHolder viewHolder;
		
		//check if our view is null. In that case, make a new view, otherwise, just re-use the previous view
		if(convertView==null){
			//initialize view holder
			viewHolder=new ViewHolder();
			//get an instance of layout inflator
			LayoutInflater mInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			
			//inflate our view with the layout that we created earlier
			convertView=mInflater.inflate(R.layout.layout_custom_row, parent, false);
			
			//get the reference of textview from inflated view and put it inside viewholder instance
			viewHolder.customTv=(TextView)convertView.findViewById(R.id.tv_custom);
			
			//do the same with imageview
			viewHolder.customIv=(ImageView)convertView.findViewById(R.id.iv_launcher);
			
			//now store the instance of viewholder inside convertview so that we can re-use it
			convertView.setTag(viewHolder);
		}
		else{
			//convert view wasn't null. Now, we need to retake our view holder from convert view and use it
			viewHolder=(ViewHolder)convertView.getTag();
		}
		
		//set some text to it by taking it from list that we passed from activity
		viewHolder.customTv.setText((String)getItem(position));
		
		//return the view at the end
		return convertView;
	}
	
	private class ViewHolder{
		private TextView customTv;
		private ImageView customIv;
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
