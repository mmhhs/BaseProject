package com.base.feima.baseproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.feima.baseproject.R;
import com.widget.niftynotification.lib.Effects;
import com.widget.sample.SampleUltimateActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestFragment extends Fragment{
    private Effects effect = Effects.flip;
    private View rootView;// ����Fragment view
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (rootView == null)
        {
            rootView = inflater.inflate(R.layout.sample, null);
            initView(rootView);
            initData();
        }
        // �����rootView��Ҫ�ж��Ƿ��Ѿ����ӹ�parent�������parent��Ҫ��parentɾ����Ҫ��Ȼ�ᷢ�����rootview�Ѿ���parent�Ĵ���
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

    private void initView(View rootView){
        ButterKnife.inject(this, rootView);
    }


    private void initData(){

    }


    @OnClick(R.id.imagegg)
    public void setText() {
        Intent intent = new Intent(getActivity(), SampleUltimateActivity.class);
        startActivity(intent);

    }



}
