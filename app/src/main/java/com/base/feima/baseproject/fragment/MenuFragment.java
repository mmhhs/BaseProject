package com.base.feima.baseproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.feima.baseproject.R;

public class MenuFragment extends Fragment
{
	private View rootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
    	if (rootView == null)
        {
          rootView = inflater.inflate(R.layout.sample_base_pullable_activity_listview, null);
          initView();
          initData();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null)
        {
          parent.removeView(rootView);
        }
        return rootView;
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
    
    private void initView(){

    }
    

    private void initData(){

    }




    }
