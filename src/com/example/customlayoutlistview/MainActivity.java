package com.example.customlayoutlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private Context context=this;
	private CustomViewAdapter customViewAdapter=new CustomViewAdapter(null, null);

	private ListView customViewLv;

	private ArrayList<String> list=new ArrayList<String>(15);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		//get reference to arraylist from xml
		customViewLv=(ListView)findViewById(R.id.lv_custom_layout);
		
		//put some dummy values in arraylist
		fillArrayList();
		
		//set context and list to our adapter
		customViewAdapter.setContext(context);
		customViewAdapter.setList(list);
		
		//set adapter to listview
		customViewLv.setAdapter(customViewAdapter);
	}
	
	private void fillArrayList(){
		for(int idx=0; idx<15; idx++){
			list.add(idx, "This is "+idx+"th position");
		}
	}
}