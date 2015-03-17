package com.base.feima.baseproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.base.feima.baseproject.R;
import com.widget.niftynotification.lib.Effects;
import com.widget.niftynotification.lib.NiftyNotificationView;
import com.widget.pulltorefresh.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment
{
    private Effects effect = Effects.flip;
    SwipeRefreshView swipeRefreshView;
    RecyclerView recyclerView;
	private View rootView;// ����Fragment view
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
    	if (rootView == null)
        {
          rootView = inflater.inflate(R.layout.sample_swipe_refresh_view, null);
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
        swipeRefreshView = (SwipeRefreshView)rootView.findViewById(R.id.swipe);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.rvFeed);
    }
    

    private void initData(){
    swipeRefreshView.setColorSchemeResources(android.R.color.holo_red_light,android.R.color.holo_green_light, android.R.color.holo_blue_bright, android.R.color.holo_orange_light);
    //      swipeRefreshView.setProgressBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
    swipeRefreshView.setSize(0);//0��1  Բ�ν��������ֲ�ͬЧ�� 0�տ�ʼ����ȾЧ��
        //�������ֹ�����
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        //��ʼ������
        List<Bean> myDataset = new ArrayList<Bean>();

        myDataset.add(new Bean(Bean.Z_TYPE, "ͼƬ"));
        myDataset.add(new Bean(Bean.X_TYPE, "����"));
        myDataset.add(new Bean(Bean.Y_TYPE, "��ť"));
        myDataset.add(new Bean(Bean.Z_TYPE, "ͼƬ"));
        myDataset.add(new Bean(Bean.X_TYPE, "shit"));
        myDataset.add(new Bean(Bean.X_TYPE, "�Ҳ�"));
        myDataset.add(new Bean(Bean.Z_TYPE, "ͼƬ"));
        myDataset.add(new Bean(Bean.Y_TYPE, "��ť"));
        myDataset.add(new Bean(Bean.Y_TYPE, "��ť"));
        myDataset.add(new Bean(Bean.X_TYPE, "����"));
        //����Adapter
        RecycleAdapter mAdapter = new RecycleAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

    swipeRefreshView.setView(getActivity(), recyclerView);//����Ƕ�׵���view -listview
    swipeRefreshView.setMoreData(true);//�����Ƿ������ݿɼ���(һ����ݷ���������������)

    swipeRefreshView.setOnRefreshListener(new SwipeRefreshView.OnRefreshListener() {
    @Override
    public void onRefresh() {
        swipeRefreshView.setRefreshing(false);
        swipeRefreshView.setMoreData(true);
        String msg="Today welike to share a couple of simple styles and effects for android notifications.";
        NiftyNotificationView.build(getActivity(), msg, effect, R.id.base_ui_home_frame)
                .setIcon(R.drawable.ic_launcher)         //You must call this method if you use ThumbSlider effect
                .show();
    }
    });
    swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
    @Override
    public void onLoadMore() {
        String msg="Today welike to share a couple of simple styles and effects for android notifications.";
        NiftyNotificationView.build(getActivity(), msg, effect, R.id.base_ui_home_frame)
                .setIcon(R.drawable.ic_launcher)         //You must call this method if you use ThumbSlider effect
                .show();
        swipeRefreshView.setLoading(false);
    }
    });
    }


    public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<Bean> beans;

        public RecycleAdapter(List<Bean> beans) {
            super();
            this.beans = beans;
        }

        /**
         * �ڲ�TextHoler
         *
         * @author edsheng
         *
         */
        public class TextHoler extends RecyclerView.ViewHolder {
            public TextView textView;

            public TextHoler(View textview) {
                super(textview);
                this.textView = (TextView) textview.findViewById(R.id.texttt);
            }
        }

        /**
         * iamgeHolder
         *
         * @author edsheng
         *
         */
        public class ImageHoler extends RecyclerView.ViewHolder {
            public ImageView Imageview;

            public ImageHoler(View textview) {
                super(textview);
                this.Imageview = (ImageView) textview.findViewById(R.id.imagegg);
            }
        }

        /**
         * ��ť��holder
         *
         * @author edsheng
         *
         */
        public class ButtonHolder extends RecyclerView.ViewHolder {
            public Button button;

            public ButtonHolder(View textview) {
                super(textview);
                this.button = (Button) textview.findViewById(R.id.buttonbbb);
            }
        }

        @Override
        public int getItemCount() {
            // TODO Auto-generated method stub
            return beans.size();
        }

        /**
         * ��ȡ��Ϣ������
         */
        @Override
        public int getItemViewType(int position) {
            // TODO Auto-generated method stub
            return beans.get(position).getType();
        }

        /**
         * ����VIewHolder
         */
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
            // TODO Auto-generated method stub
            View v = null;
            RecyclerView.ViewHolder holer = null;
            switch (viewtype) {
                case Bean.X_TYPE:
                    v = LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.sample, null);
                    holer = new TextHoler(v);
                    break;
                case Bean.Y_TYPE:
                    v = LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.sample, null);
                    holer = new ButtonHolder(v);
                    break;
                case Bean.Z_TYPE:
                    v = LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.sample, null);
                    holer = new ImageHoler(v);
                    break;
            }

            return holer;
        }

        /**
         * ��viewholder
         */
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            // TODO Auto-generated method stub
            switch (getItemViewType(position)) {
                case Bean.X_TYPE:
                    TextHoler textholer = (TextHoler) holder;
                    textholer.textView.setText(beans.get(position).getText());
                    break;
                case Bean.Y_TYPE:
                    ButtonHolder buttonHolder = (ButtonHolder) holder;
                    buttonHolder.button.setText(beans.get(position).getText());
                    break;
                case Bean.Z_TYPE:
                    ImageHoler imageHoler = (ImageHoler) holder;
                    // imageHoler.Imageview.setImageResource(android.R.drawable.checkbox_on_background);
                    break;
            }
        }
    }

    public class Bean {
        public static final int Y_TYPE = 0; //view����0
        public static final int X_TYPE = 1; //view����2
        public static final int Z_TYPE = 2;//view ����3
        private int type;
        private String text;

        public Bean(int type, String text) {
            super();
            this.type = type;
            this.text = text;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

    }
