package com.widget.pulltorefresh;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;

import com.base.feima.baseproject.R;

/**
 * Created by veidy on 2015/1/16.
 */
public class SwipeRefreshView extends SwipeRefreshLayout implements AbsListView.OnScrollListener {
    /**
     * ������������ʱ����������
     */
    private int mTouchSlop;
    /**
     * listviewʵ��
     */
    private ListView mListView;
    /**
     * RecyclerView ʵ��
     */
    private RecyclerView recyclerView;
    /**
     * ����������, ������ײ����������ز���
     */
    private OnLoadListener mOnLoadListener;
    /**
     * ListView�ļ�����footer
     */
    private View mFooterView;
    /**
     * ����ʱ��y����
     */
    private int mYDown;
    /**
     * ̧��ʱ��y����, ��mYDownһ�����ڻ������ײ�ʱ�ж���������������
     */
//    private int mLastY;
    /**
     * �Ƿ��ڼ����� ( �������ظ��� )
     */
    private boolean isLoading = false;
    private float mLastY = -1;
    /**
     * ���һ��
     */
    boolean isLastRow = false;
    /**
     * �Ƿ������ݿ��Լ���
     */
    private boolean moreData = true;
    public SwipeRefreshView(Context context) {
        super(context);
    }
    public SwipeRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mFooterView = LayoutInflater.from(context).inflate(R.layout.base_ui_welcome, null, false);
    }
    /**
     * ����Ĭ�ϵ�childview-����Ҫ����
     *
     * @param context
     * @param childView
     */
    public void setView(Context context, View childView) {
        if (childView instanceof ListView) {
            mListView = (ListView) childView;
            // ���ù�����������ListView, ʹ�ù����������Ҳ�����Զ�����
            mListView.setOnScrollListener(this);
            mListView.setFooterDividersEnabled(false);
            Log.d("SwipeRefreshView", "��ȡ��listview");
        } else if (childView instanceof RecyclerView) {
            recyclerView = (RecyclerView) childView;
            // ���ù�����������ListView, ʹ�ù����������Ҳ�����Զ�����
            recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    int lastVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                    //lastVisibleItem >= totalItemCount - 4 ��ʾʣ��4��item�Զ�����
                    // dy>0 ��ʾ���»���
                    if (lastVisibleItem >= totalItemCount -1 && dy > 0) {
                        isLastRow = true;
                        loadData();
                    }else {
                        isLastRow = false;
                    }

                }
            });
            Log.d("SwipeRefreshView", "��ȡ��recyclerView");
        }
        initWithContext(context);
    }
    private void initWithContext(Context context) {
        if (mListView != null)
            mListView.addFooterView(mFooterView, null, false);//����footview���ɵ��
//        if (recyclerView!=null){
//            Log.d("SwipeRefreshView","��ȥ�Զ���recyclerView ��footview��");
//            return;
//        }
        mFooterView.setVisibility(View.GONE);//Ĭ��������
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        try {
            super.onLayout(changed, left, top, right, bottom);
        }catch (Exception e){

        }

    }
    /**
     * �Ƿ���Լ��ظ���, listview���ڼ�����, ��Ϊ��������.
     *
     * @param canload �Ƿ��п��Լ��ص�����
     * @return
     */
    private boolean canLoad(boolean canload) {
        return canload && !isLoading && isPullUp();
    }
    /**
     * �ж��Ƿ�����ײ�
     */
    private boolean isBottom() {
        if (mListView != null && mListView.getAdapter() != null) {
            return mListView.getLastVisiblePosition() == (mListView.getAdapter().getCount() - 1);
        }
        return false;
    }
    /**
     * �Ƿ�����������
     *
     * @return
     */
    private boolean isPullUp() {
        Log.d("SwipeRefreshView", "isPullUp--->");
        return (mYDown - mLastY) >= mTouchSlop;
    }
    /**
     * ���������ײ�,��������������.onLoadMore
     */
    private void loadData() {
        Log.d("SwipeRefreshView", "loadData--->");
        if (mOnLoadListener != null) {
            // ����״̬
            setLoading(true);
            mOnLoadListener.onLoadMore();
        }
    }
    /**
     * @param loading
     */
    public void setLoading(boolean loading) {
        isLoading = loading;
        if (isLoading) {
//            mListView.addFooterView(mFooterView);
            mFooterView.setVisibility(View.VISIBLE);
        } else {
//            mListView.removeFooterView(mFooterView);
            mFooterView.setVisibility(View.GONE);
            mYDown = 0;
            mLastY = 0;
        }
    }
    /*
       * (non-Javadoc)
       * @see android.view.ViewGroup#dispatchTouchEvent(android.view.MotionEvent)
       */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        if (mLastY == -1) {
            mLastY = (int) event.getRawY();
        }
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // ����
                mYDown = (int) event.getRawY();
                Log.d("SwipeRefreshView", "����");
                break;
            case MotionEvent.ACTION_MOVE:
                // �ƶ�
                mLastY = (int) event.getRawY();
                final float deltaY = event.getRawY() - mLastY;
                Log.d("SwipeRefreshView", "�ƶ�");
//                if (null != mListView && isPullUp()) {
//                    if (mListView.getLastVisiblePosition() == mTotalItemCount - 1 || deltaY < 0) {
//                        mListView.setSelection(mTotalItemCount - 1);
//                    }
//                }
                break;
            default:
//                if (isLastRow && canLoad(moreData)) {
//                    Log.d("SwipeRefreshView", "�ܼ���...");
//                    loadData();
//                } else {
//                    Log.d("SwipeRefreshView", "���ܼ���...");
//                }
                break;
        }
        return super.dispatchTouchEvent(event);
    }
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    /**
     * @param loadListener
     */
    public void setOnLoadListener(OnLoadListener loadListener) {
        mOnLoadListener = loadListener;
    }
    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //�ж��Ƿ�������һ��
        if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount > 0) {
            //˫���жϣ�Ӧ��û�б�Ҫ
            if (absListView.getLastVisiblePosition() == (absListView.getAdapter().getCount() - 1)) {
                isLastRow = true;
//                mFooterView.setVisibility(View.VISIBLE);
                if (canLoad(moreData)) {
                    Log.d("SwipeRefreshView", "���������һ��,�������ݣ���ʾfootview");
                    loadData();
                }
            }
            Log.d("SwipeRefreshView", "���������һ��");
        } else {
            Log.d("SwipeRefreshView", "û�й��������һ��");
            isLastRow = false;
        }
    }
    public static interface OnLoadListener {
        public void onLoadMore();
    }
    public boolean isMoreData() {
        return moreData;
    }
    public void setMoreData(boolean moreData) {
        this.moreData = moreData;
    }
}