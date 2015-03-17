package com.widget.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.base.feima.baseproject.R;
import com.widget.niftynotification.lib.Effects;
import com.widget.niftynotification.lib.NiftyNotificationView;

public class SampleNiftyNotificationActivity extends Activity {
    private Effects effect = Effects.flip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_ui_home);
    }

    public void showNotify(View v){

        String msg="Today welike to share a couple of simple styles and effects for android notifications.";
        NiftyNotificationView.build(this, msg, effect, R.id.base_ui_home_frame)
                .setIcon(R.drawable.ic_launcher)         //You must call this method if you use ThumbSlider effect
                .showSticky();
//        You can configure like this
//        The default

//        Configuration cfg=new Configuration.Builder()
//                .setAnimDuration(700)
//                .setDispalyDuration(1500)
//                .setBackgroundColor("#FFBDC3C7")
//                .setTextColor("#FF444444")
//                .setIconBackgroundColor("#FFFFFFFF")
//                .setTextPadding(5)                      //dp
//                .setViewHeight(48)                      //dp
//                .setTextLines(2)                        //You had better use setViewHeight and setTextLines together
//                .setTextGravity(Gravity.CENTER)         //only text def  Gravity.CENTER,contain icon Gravity.CENTER_VERTICAL
//                .build();
//
//        NiftyNotificationView.build(this,msg, effect,R.id.mLyout,cfg)
//                .setIcon(R.drawable.lion)               //remove this line ,only text
//                .setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //add your code
//                    }
//                })
//                .show();                               //  show(boolean) allow duplicates   or showSticky() sticky notification,you can call removeSticky() method close it
    }

}
