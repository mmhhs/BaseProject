package com.base.feima.baseproject.activity;


import android.app.Activity;
import android.os.Bundle;

import com.base.feima.baseproject.R;


public class DemoActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_fragment_welcome);
		
		
		initView();
		initData();
	}
	
	private void initView(){
		
	}
	
	private void initData(){
		
	}
}