package com.base.feima.baseproject.activity;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.base.feima.baseproject.R;
import com.base.feima.baseproject.base.BaseFragmentActivity;
import com.base.feima.baseproject.fragment.MenuFragment;

import com.widget.sample.SampleSrainMaterialFragment;


public class BaseHomeActivity extends BaseFragmentActivity implements OnCheckedChangeListener{
	private FrameLayout frameLayout;
	private RadioButton rb0,rb1,rb2,rb3,rb4;
	private int rbFlag = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
	        finish(); 
	        return; 
	    } 
        setContentView(R.layout.base_ui_home);
        setTaskTag(getLocalClassName());
		initView();
		
    }
       
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {      
		super.onConfigurationChanged(newConfig);
    }
    
    private void initView(){
    	frameLayout = (FrameLayout) findViewById(R.id.base_ui_home_frame);
    	
    	rb0 = (RadioButton) findViewById(R.id.base_ui_home_radio0);
    	rb1 = (RadioButton) findViewById(R.id.base_ui_home_radio1);
    	rb2 = (RadioButton) findViewById(R.id.base_ui_home_radio2);
    	rb3 = (RadioButton) findViewById(R.id.base_ui_home_radio3);
    	rb4 = (RadioButton) findViewById(R.id.base_ui_home_radio4);
    	rb0.setOnCheckedChangeListener(this);
    	rb1.setOnCheckedChangeListener(this);
    	rb2.setOnCheckedChangeListener(this);
    	rb3.setOnCheckedChangeListener(this);
    	rb4.setOnCheckedChangeListener(this);
    	
    	rb0.performClick();

    }

 private FragmentPagerAdapter mFragmentPagerAdapter =  new  FragmentPagerAdapter(getSupportFragmentManager()) {

        @Override 
         public Fragment getItem( int  position) {
             switch  (position) { 
             case  R.id.base_ui_home_radio0:
            	 
                 return   new MenuFragment();
             case  R.id.base_ui_home_radio1:
            	 
                 return   new SampleSrainMaterialFragment();
             case  R.id.base_ui_home_radio2:
            	 
                 return  new MenuFragment();
             case  R.id.base_ui_home_radio3:
            	 
                 return  new MenuFragment();
             case  R.id.base_ui_home_radio4:
            	
                 return  new MenuFragment();
             default : 
                 return  new MenuFragment();
            } 
        } 

        @Override 
         public   int  getCount() { 
             return  5; 
        } 
    };
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if  (isChecked) { 
	       	 switch  (buttonView.getId()) { 
	            case  R.id.base_ui_home_radio0:
	           	 rbFlag = 0;
	           	 instantFragment(buttonView);
	                break;
	            case  R.id.base_ui_home_radio1:
	           	 rbFlag = 1;
	           	 instantFragment(buttonView);
	           	 break;
	            case  R.id.base_ui_home_radio2:
	           	 rbFlag = 2;
	           	 instantFragment(buttonView);
	           	 break;
	            case  R.id.base_ui_home_radio3:
	           	 rbFlag = 3;            	 
	           	 instantFragment(buttonView);
	           	 break;
	            case  R.id.base_ui_home_radio4:
	           	 rbFlag = 4;
	           	 instantFragment(buttonView);
	           	 break;       
	            default : 
	           	 instantFragment(buttonView);
	           	 break;
	           }
	       }  
	}


	private void instantFragment(CompoundButton buttonView){
		 try {
			 Fragment fragment = (Fragment) mFragmentPagerAdapter.instantiateItem(frameLayout, buttonView.getId());
	         mFragmentPagerAdapter.setPrimaryItem(frameLayout, 0, fragment); 
	         mFragmentPagerAdapter.finishUpdate(frameLayout);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 }
    
      
}
