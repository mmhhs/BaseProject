package com.base.feima.baseproject.activity;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.TabSpec;

import com.base.feima.baseproject.R;
import com.base.feima.baseproject.base.BaseFragmentActivity;
import com.base.feima.baseproject.fragment.MenuFragment;

import com.base.feima.baseproject.fragment.TestFragment;
import com.widget.test.TestSrainMaterialFragment;


public class BaseHomeTabActivity extends BaseFragmentActivity{
	private FragmentTabHost mTabHost;
	private RadioGroup mTabRg;

	private final Class[] fragments = { TestSrainMaterialFragment.class, MenuFragment.class,
			TestFragment.class, MenuFragment.class };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) { 
	        /*
	        Activity was brought to front and not created,
	        Thus finishing this will get us to the last viewed activity
	        */
            finish();
	        return; 
	    } 
        setContentView(R.layout.base_ui_home);
        setTagString(getLocalClassName());
		initView();
		
    }
       
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {      
		super.onConfigurationChanged(newConfig);
    }
    
    private void initView(){
    	mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.base_ui_home_frame);
		/* 得到fragment的个数 */
		int count = fragments.length;
		for (int i = 0; i < count; i++) {
			/* 为每一个Tab按钮设置图标、文字和内容 */
			TabSpec tabSpec = mTabHost.newTabSpec(i + "").setIndicator(i + "");
			/* 将Tab按钮添加进Tab选项卡中 */
			mTabHost.addTab(tabSpec, fragments[i], null);
		}

		mTabRg = (RadioGroup) findViewById(R.id.base_ui_home_radiogroup);
		mTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.base_ui_home_radio0:
					mTabHost.setCurrentTab(0);
					break;
				case R.id.base_ui_home_radio1:
					mTabHost.setCurrentTab(1);

					break;
				case R.id.base_ui_home_radio2:

					mTabHost.setCurrentTab(2);
					break;
				case R.id.base_ui_home_radio3:

					mTabHost.setCurrentTab(3);
					break;

				default:
					break;
				}
			}
		});

		mTabHost.setCurrentTab(0);

    }

 
    
      
}
