package com.base.feima.baseproject.base;


import android.app.Activity;
import android.os.Bundle;

import com.base.feima.baseproject.task.BaseTask;
import com.base.feima.baseproject.task.TaskManager;
import com.base.feima.baseproject.util.ScreenManager;


public class BaseActivity extends Activity{
	public String taskTag = "BaseActivity";
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
     * ����̵߳��̹߳�����
     * @param task
     */
	protected void addTask(BaseTask task){
		try {
			taskManager.addTask(taskTag, task);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

    /**
     * �رյ�ǰActivity�����л������е��߳�
     */
	protected void cancelTasks(){
		taskManager.cancelLimitTasks(taskTag);
	}

    /**
     * �رյ�ǰActivity
     */
	public void finishSelf(){
		try {
			screenManager.finishActivity(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

    /**
     * ��ȡ�̱߳�ʶ
     * @return
     */
	public String getTaskTag() {
		return taskTag;
	}

    /**
     * �����̱߳�ʶ
     * @param taskTag
     */
	public void setTaskTag(String taskTag) {
		this.taskTag = taskTag;
	}
	
	
}