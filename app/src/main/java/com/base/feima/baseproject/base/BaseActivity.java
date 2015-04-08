package com.base.feima.baseproject.base;


import android.app.Activity;
import android.os.Bundle;

import com.base.feima.baseproject.task.BaseTask;
import com.base.feima.baseproject.task.TaskManager;
import com.base.feima.baseproject.util.ScreenManager;


public class BaseActivity extends Activity{
	public String tagString = "BaseActivity";
	protected ScreenManager screenManager = ScreenManager.getScreenManagerInstance();
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

    /**
     * 添加线程到线程管理中
     * @param task
     */
	protected void addTask(BaseTask task){
		try {
			taskManager.addTask(tagString, task);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

    /**
     * 关闭当前Activity中所有还在运行的线程
     */
	protected void cancelTasks(){
		taskManager.cancelLimitTasks(tagString);
	}

    /**
     * 关闭当前Activity
     */
	public void finishSelf(){
		try {
			screenManager.finishActivity(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

    /**
     * 获取线程标识
     * @return
     */
	public String getTagString() {
		return tagString;
	}

    /**
     * 设置线程标识
     * @param taskTag
     */
	public void setTagString(String tagString) {
		this.tagString = tagString;
	}
	
	
}