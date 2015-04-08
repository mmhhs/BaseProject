package com.base.feima.baseproject.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.base.feima.baseproject.task.BaseTask;
import com.base.feima.baseproject.task.TaskManager;
import com.base.feima.baseproject.util.MFragmentsManager;


public abstract class BaseFragment extends Fragment {
	public String taskTag = "BaseFragment";//当前Fragment的线程标识
	public TaskManager taskManager = TaskManager.getTaskManagerInstance();
    public MFragmentsManager mFragmentsManager = MFragmentsManager.getFragmentManagerInstance();
    public View rootView;

	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        mFragmentsManager.addFragment(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
	public void onPause(){
		super.onPause();
	}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rootView = null;
    }

    @Override
	public void onDestroy(){
		super.onDestroy();
		cancelTasks();
	}

    /**
     * 初始化视图相关操作
     */
    public abstract void initView();

    /**
     * 初始化数据相关操作
     */
    public abstract void initData();

    /**
     * 添加线程到线程管理中
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
     * 关闭当前Fragment中所有还在运行的线程
     */
	protected void cancelTasks(){
		taskManager.cancelLimitTasks(taskTag);
	}

    /**
     * 获取线程标识
     * @return
     */
	public String getTaskTag() {
		return taskTag;
	}

    /**
     * 设置线程标识
     * @param taskTag
     */
	public void setTaskTag(String taskTag) {
		this.taskTag = taskTag;
	}


	
	
	
}