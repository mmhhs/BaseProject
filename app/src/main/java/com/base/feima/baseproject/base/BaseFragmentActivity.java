package com.base.feima.baseproject.base;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.base.feima.baseproject.task.BaseTask;
import com.base.feima.baseproject.task.TaskManager;
import com.base.feima.baseproject.util.ScreenManager;

public class BaseFragmentActivity extends FragmentActivity {
	public String tagString = "BaseFragmentActivity";
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
     * 关闭当前FragmentActivity中所有还在运行的线程
     */
	protected void cancelTasks(){
		taskManager.cancelLimitTasks(tagString);
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