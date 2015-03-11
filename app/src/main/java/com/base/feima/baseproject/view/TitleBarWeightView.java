package com.base.feima.baseproject.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TitleBarWeightView extends LinearLayout {
	private final String TAGS = "TitleBarWeightView";
	private final PageListener pageListener = new PageListener();
	public OnPageChangeListener delegatePageListener;
	private ViewPager pager;
	private List<TextView> textViewList = new ArrayList<TextView>();
	private List<TitleItem> titleItemList;
	private LayoutParams defaultTabLayoutParams;
	private Context context;
	private boolean moveAble = true;
	public OnChangeListener onChangeListener;

	public TitleBarWeightView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		defaultTabLayoutParams = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		defaultTabLayoutParams.gravity = Gravity.CENTER_VERTICAL;
		defaultTabLayoutParams.weight = 1;
	}

	public TitleBarWeightView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context = context;
		defaultTabLayoutParams = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		defaultTabLayoutParams.gravity = Gravity.CENTER_VERTICAL;
		defaultTabLayoutParams.weight = 1;
	}

	public TitleBarWeightView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
		defaultTabLayoutParams = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		defaultTabLayoutParams.gravity = Gravity.CENTER_VERTICAL;
		defaultTabLayoutParams.weight = 1;
	}

	public void init(Context context, List<TitleItem> titleItemList,
			ViewPager pager, int index) {
		this.context = context;
		this.titleItemList = titleItemList;
		setViewPager(pager);
		addTextViewList();
		setItemStatus(index);
		setPager(index);
	}

	public void addTextViewList() {
		if (titleItemList != null && titleItemList.size() > 0) {
			for (int i = 0; i < titleItemList.size(); i++) {
				addItem(i);
			}
		} else {
			Log.i(TAGS, "drawableList null or empty");
		}
	}

	private void addItem(final int position) {
		TitleItem titleItem = titleItemList.get(position);
		TextView textView = new TextView(context);
		textView.setLayoutParams(defaultTabLayoutParams);
		textView.setBackground(titleItem.getBackground());
		textView.setText(titleItem.getName());
		if(titleItem.getWidth()>0){
			int w = dip2px(context, titleItem.getWidth());
			textView.setWidth(w);
		}
		if(titleItem.getHeigh()>0){
			int h = dip2px(context, titleItem.getHeigh());
			textView.setHeight(h);
		}
//		
		textView.setGravity(Gravity.CENTER);
//		textView.setTextSize(titleItem.getTextSize());
//		textView.setTextColor(titleItem.getTextColor());
		textView.setTextAppearance(context, titleItem.getTextStyle());
		textView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (moveAble) {
					setItemStatus(position);
					setPager(position);
				}

			}

		});
		textViewList.add(textView);
		addView(textView);
	}

	private void setItemStatus(int position) {
		if (textViewList != null && position < textViewList.size()) {
			for (int i = 0; i < textViewList.size(); i++) {
				textViewList.get(i).setSelected(false);
			}
			textViewList.get(position).setSelected(true);
		}
	}

	private void setPager(int position) {
		if (this.pager != null && this.pager.getAdapter() != null
				&& position < this.pager.getAdapter().getCount()) {
			this.pager.setCurrentItem(position, true);
		}
	}

	public void setViewPager(ViewPager pager) {
		this.pager = pager;

		if (pager.getAdapter() == null) {
			throw new IllegalStateException(
					"ViewPager does not have adapter instance.");
		}

		pager.setOnPageChangeListener(pageListener);

		notifyDataSetChanged();
	}

	public void setOnPageChangeListener(OnPageChangeListener listener) {
		this.delegatePageListener = listener;
	}

	public void notifyDataSetChanged() {

	}

	public boolean isMoveAble() {
		return moveAble;
	}

	public void setMoveAble(boolean moveAble) {
		this.moveAble = moveAble;
	}

	private class PageListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int state) {
			// TODO Auto-generated method stub

//			if (state == ViewPager.SCROLL_STATE_IDLE) {
//				if (moveAble) {
//					setItemStatus(pager.getCurrentItem());
//					doOnChangeListener(pager.getCurrentItem());
//				}
//
//			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			if (moveAble) {
				setItemStatus(position);
				doOnChangeListener(position);
			}
		}

	}

	/**
	 * dpת��Ϊpx
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * pxת��Ϊdp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static class TitleItem {
		public String name;
		public int width;
		public int heigh;
		public Drawable background;
		public int textColor;
		public float textSize;
		public int textStyle;

		public TitleItem() {

		}

		
		public int getTextStyle() {
			return textStyle;
		}


		public void setTextStyle(int textStyle) {
			this.textStyle = textStyle;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeigh() {
			return heigh;
		}

		public void setHeigh(int heigh) {
			this.heigh = heigh;
		}

		public Drawable getBackground() {
			return background;
		}

		public void setBackground(Drawable background) {
			this.background = background;
		}

		public int getTextColor() {
			return textColor;
		}

		public void setTextColor(int textColor) {
			this.textColor = textColor;
		}

		public float getTextSize() {
			return textSize;
		}

		public void setTextSize(float textSize) {
			this.textSize = textSize;
		}

	}
	
	public interface OnChangeListener {
		  public void   onClick(int position);
	}
	public void doOnChangeListener(int position) {
		if(onChangeListener!=null){
			onChangeListener.onClick(position);
		}
	    
	  }
	 
  public void setOnChangeListener(OnChangeListener callback) {
      this.onChangeListener = callback;
  }

}