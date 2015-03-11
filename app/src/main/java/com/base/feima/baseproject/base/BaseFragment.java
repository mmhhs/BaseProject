package com.base.feima.baseproject.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.base.feima.baseproject.task.BaseTask;
import com.base.feima.baseproject.task.TaskManager;


public class BaseFragment extends Fragment {
	public String tagString = "BaseFragment";
	public TaskManager taskManager = TaskManager.getTaskManagerInstance();
	
	protected Activity activity;
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		this.activity = activity;
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
	}
	
	@Override
	public void onPause(){
		super.onPause();
	}
	
	@Override
	public void onResume(){
		super.onResume();
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		cancelTasks();
	}
	
	protected void addTask(BaseTask task){
		try {
			taskManager.addTask(tagString, task);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}			
	}
	
	protected void cancelTasks(){
		taskManager.cancelLimitTasks(tagString);
	}


	public String getTagString() {
		return tagString;
	}


	public void setTagString(String tagString) {
		this.tagString = tagString;
	}


	
	
	
}