package com.base.feima.baseproject.tool;

import android.content.Context;

import com.base.feima.baseproject.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class OptionTools {
	
	
	public static DisplayImageOptions getBaseOptions(Context context){
		DisplayImageOptions options = new DisplayImageOptions.Builder()		
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.considerExifParams(true)
		.showImageOnLoading(R.drawable.base_pop_load)
		.showImageOnFail(R.drawable.base_pop_load)
		.showImageForEmptyUri(R.drawable.base_pop_load)
		.build();
		return options;
	}
	
	public static DisplayImageOptions getNoDiscOptions(Context context){
		DisplayImageOptions options = new DisplayImageOptions.Builder()		
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.considerExifParams(true)
		.showImageOnLoading(R.drawable.base_pop_load)
		.showImageOnFail(R.drawable.base_pop_load)
		.showImageForEmptyUri(R.drawable.base_pop_load)
		.build();
		return options;
	}


	public static DisplayImageOptions getCircleOptions(Context context){
		DisplayImageOptions options = new DisplayImageOptions.Builder()		
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.considerExifParams(true)		
		.displayer(new RoundedBitmapDisplayer(100))
		.showImageOnLoading(R.drawable.base_pop_load)
		.showImageOnFail(R.drawable.base_pop_load)
		.showImageForEmptyUri(R.drawable.base_pop_load)
		.build();
		return options;
	}	
	
	public static DisplayImageOptions getRoundOptions(Context context){
		DisplayImageOptions options = new DisplayImageOptions.Builder()		
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.considerExifParams(true)		
		.displayer(new RoundedBitmapDisplayer(5))
		.showImageOnLoading(R.drawable.base_pop_load)
		.showImageOnFail(R.drawable.base_pop_load)
		.showImageForEmptyUri(R.drawable.base_pop_load)
		.build();
		return options;
	}
	
}