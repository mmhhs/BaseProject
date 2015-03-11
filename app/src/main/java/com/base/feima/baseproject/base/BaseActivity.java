package com.base.feima.baseproject.base;


import android.app.Activity;
import android.os.Bundle;

import com.base.feima.baseproject.task.BaseTask;
import com.base.feima.baseproject.task.TaskManager;
import com.base.feima.baseproject.util.ScreenManager;


public class BaseActivity extends Activity{
	public String tagString = "BaseActivity";
	protected ScreenManager screenManager = ScreenManager.getScreenManager();
	public TaskManager taskManager = TaskManager.getTaskManagerInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		screenManager.pushActivity(this);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
	}
	
	@Override
	protected void onDestroy(){
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
	
	public void finishCurrent(){
		try {
			screenManager.finishActivity(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	public String getTagString() {
		return tagString;
	}

	public void setTagString(String tagString) {
		this.tagString = tagString;
	}
	
	
}