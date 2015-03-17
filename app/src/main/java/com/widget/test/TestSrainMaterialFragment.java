package com.widget.test;

import com.base.feima.baseproject.R;
import com.base.feima.baseproject.base.BaseFragment;
import com.base.feima.baseproject.tool.ImageTools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.widget.srainfresh.PtrFrameLayout;
import com.widget.srainfresh.PtrHandler;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.widget.srainfresh.header.RentalsSunHeaderView;

public class TestSrainMaterialFragment extends BaseFragment {

    private String mUrl = "http://img5.duitang.com/uploads/blog/201407/17/20140717113117_mUssJ.thumb.jpeg";
    private long mStartLoadingTime = -1;
    private boolean mImageHasLoaded = false;
    final String[] mStringList = {"Alibaba", "TMALL 11-11"};
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
    	if (rootView == null)
        {
          rootView = inflater.inflate(R.layout.test_base_scrain_materail, null);
          final ImageView imageView = (ImageView) rootView.findViewById(R.id.material_style_image_view);
          final ImageLoader imageLoader = ImageLoader.getInstance();

          final PtrFrameLayout frame = (PtrFrameLayout) rootView.findViewById(R.id.material_style_ptr_frame);

          // header android5.0
//          final MaterialHeader header = new MaterialHeader(getActivity());
//          int[] colors = getResources().getIntArray(R.array.google_colors);
//          header.setColorSchemeColors(colors);
//          header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
//          header.setPadding(0, ImageTools.dip2px(getActivity(),15), 0, ImageTools.dip2px(getActivity(),10));
//          header.setPtrFrameLayout(frame);
          //sun
          final RentalsSunHeaderView header = new RentalsSunHeaderView(getActivity());
          header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
          header.setPadding(0, ImageTools.dip2px(getActivity(),15), 0, ImageTools.dip2px(getActivity(),10));
          header.setUp(frame);
          //house
//          final StoreHouseHeader header = new StoreHouseHeader(getActivity());
//          header.setPadding(0, ImageTools.dip2px(getActivity(),15), 0, 0);
//          /**
//           * using a string, support: A-Z 0-9 - .
//           * you can add more letters by {@link in.srain.cube.views.ptr.header.StoreHousePath#addChar}
//           */
//          header.initWithString(mStringList[0]);
//          // for changing string
//          frame.addPtrUIHandler(new PtrUIHandler() {
  //
//              private int mLoadTime = 0;
  //
//              @Override
//              public void onUIReset(PtrFrameLayout frame) {
//                  mLoadTime++;
//                  String string = mStringList[mLoadTime % mStringList.length];
//                  header.initWithString(string);
//              }
  //
//              @Override
//              public void onUIRefreshPrepare(PtrFrameLayout frame) {
//                  
//              }
  //
//              @Override
//              public void onUIRefreshBegin(PtrFrameLayout frame) {
  //
//              }
  //
//              @Override
//              public void onUIRefreshComplete(PtrFrameLayout frame) {
  //
//              }
  //
//  			@Override
//  			public void onUIPositionChange(PtrFrameLayout frame,
//  					boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
//  				// TODO Auto-generated method stub
//  				
//  			}
//          });

          frame.setLoadingMinTime(1000);
          frame.setDurationToCloseHeader(1000);
          frame.setHeaderView(header);
          frame.addPtrUIHandler(header);
          frame.postDelayed(new Runnable() {
              @Override
              public void run() {
                  frame.autoRefresh(false);
              }
          }, 100);

          frame.setPtrHandler(new PtrHandler() {
              @Override
              public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                  return true;
              }

              @Override
              public void onRefreshBegin(final PtrFrameLayout frame) {
                      imageLoader.displayImage(mUrl, imageView, new ImageLoadingListener() {
  						
  						@Override
  						public void onLoadingStarted(String imageUri, View view) {
  							// TODO Auto-generated method stub
  							
  						}
  						
  						@Override
  						public void onLoadingFailed(String imageUri, View view,
  								FailReason failReason) {
  							// TODO Auto-generated method stub
  							
  						}
  						
  						@Override
  						public void onLoadingComplete(String imageUri, View view, final Bitmap bitmapDrawable) {  
  			                int delay = 500;
  			                frame.postDelayed(new Runnable() {
  			                    @Override
  			                    public void run() {
  			                        if (imageView != null && bitmapDrawable != null) {			                        	
  			                            imageView.setImageBitmap(bitmapDrawable);
  			                        }
  			                        frame.refreshComplete();
  			                    }
  			                }, delay);
  						}
  						
  						@Override
  						public void onLoadingCancelled(String imageUri, View view) {
  							// TODO Auto-generated method stub
  							
  						}
  					});
                  }
              
          });
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null)
        {
          parent.removeView(rootView);
        }
//    	View view = inflater.inflate(R.layout.fragment_materail_style, null);
        

        
        return rootView;
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }

    
}
