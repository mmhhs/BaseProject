package com.base.feima.baseproject.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ScreenManager {
	private static List<Activity> activityList = new ArrayList<Activity>();
	private static ScreenManager instance;

	private ScreenManager() {
	}

	public static ScreenManager getScreenManager() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	/**
	 * 退出栈顶Activity
	 * @param activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activity.finish();
			activityList.remove(activity);
			activity = null;
		}
	}

	/**
	 * 获得当前栈顶Activity
	 * @return
	 */
	public Activity getCurrentActivity() {
		if(activityList.size()>0){
			Activity activity = activityList.get(activityList.size()-1);
			return activity;
		}else{
			return null;
		}
		
	}

	/**
	 * 将当前Activity推入栈中
	 * @param activity
	 */	
	public void pushActivity(Activity activity) {		
		activityList.add(activity);
	}

	/**
	 * 退出栈中所有Activity
	 */	
	public void finishAllActivityExceptOne(Class cls) {
		for(int i=0;i<activityList.size();i++){
			try {
				Activity activity = activityList.get(i);
				if (activity != null&&!activity.getClass().equals(cls)) {
					finishActivity(activity);
				}				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		
	}
	
	/**
	 * 退出栈中所有Activity
	 */	
	public void finishAllActivity() {
		for(int i=0;i<activityList.size();i++){
			try {
				Activity activity = activityList.get(i);
				if (activity != null) {
					finishActivity(activity);
				}				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
	}
	
	/**
	 * 退出栈中当前Activity
	 */	
	public void finishCurrentActivity() {
		try {
			Activity activity = getCurrentActivity();
			if (activity == null) {
				return;
			}			
			finishActivity(activity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
	}
	
	/**
	 * 退出栈中指定Activity
	 */	
	public void finishOneActivity(Class cls) {
		for(int i=0;i<activityList.size();i++){
			try {
				Activity activity = activityList.get(i);
				if (activity != null&&activity.getClass().equals(cls)) {
					finishActivity(activity);
				}				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
	}
	
}