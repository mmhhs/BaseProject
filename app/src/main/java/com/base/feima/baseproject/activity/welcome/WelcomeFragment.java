package com.base.feima.baseproject.activity.welcome;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.base.feima.baseproject.R;
import com.base.feima.baseproject.base.BaseFragment;
import com.base.feima.baseproject.view.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;


public class WelcomeFragment extends BaseFragment implements OnPageChangeListener {
	private ViewPager mViewPager;
	private PageIndicatorView mPageIndicatorView;
	private ViewPagerAdapter adapter1;
	private List<Integer> imgList = new ArrayList<Integer>();
	private List<View> viewList = new ArrayList<View>();
	public IntentOnClickListener intentOnClickListener;
	private boolean clickButton = false;
	
	public WelcomeFragment(){

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.base_fragment_welcome, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mViewPager = (ViewPager) getView().findViewById(R.id.fragment_wel_view);
		mPageIndicatorView = (PageIndicatorView) getView().findViewById(R.id.fragment_wel_pageIndicatorView);
		initData();
	}
	
	private void initData(){
		imgList.add(R.drawable.base_shape_corner_white);
		for(int i=0;i<imgList.size();i++){
			View view = LayoutInflater.from(getActivity()).inflate(R.layout.base_adapter_viewpager_welcome, null);
			ImageView img = (ImageView) view.findViewById(R.id.adapter_wel_imageView1);
			img.setImageDrawable(getResources().getDrawable(imgList.get(i)));
			ImageButton imgButton = (ImageButton) view.findViewById(R.id.adapter_wel_imageButton1);
			if(i==(imgList.size()-1)){
				if(clickButton){
					imgButton.setVisibility(View.VISIBLE);
					imgButton.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							doIntentOnClickListener();

						}
						
					});
				}else{
					view.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							doIntentOnClickListener();

						}
						
					});
				}
			}else{
				imgButton.setVisibility(View.GONE);
			}
			
			viewList.add(view);
		}
//		adapter = new SingleViewPagerAdapter(context,imgList);
		adapter1 = new ViewPagerAdapter(viewList);
		mViewPager.setAdapter(adapter1);
		mViewPager.setOnPageChangeListener(this);
		mPageIndicatorView.setTotalPage(imgList.size());
		mPageIndicatorView.setCameraDistance(20);
		mPageIndicatorView.setRedius(6);
		mPageIndicatorView.setSpace(20);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		mPageIndicatorView.setCurrentPage(mViewPager.getCurrentItem());

	}
	
	//
 	public interface IntentOnClickListener {
 		  public void   onClick();
 	}
 	public void doIntentOnClickListener() {
 	    intentOnClickListener.onClick();
 	  }
 	 
    public void setIntentOnClickListener(IntentOnClickListener callback) {
        this.intentOnClickListener = callback;
    }
	
	
}
