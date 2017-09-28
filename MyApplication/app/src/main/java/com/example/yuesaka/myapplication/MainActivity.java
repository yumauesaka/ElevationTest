package com.example.yuesaka.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.top_frame)
    FrameLayout topFrame;
    @BindView(R.id.second_frame)
    FrameLayout secondFrame;
    @BindView(R.id.third_frame)
    FrameLayout thirdFrame;
    @BindView(R.id.icon1)
    ImageView icon1_sibling_view;
    @BindView(R.id.icon2)
    ImageView icon2_child_view;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        thirdFrame.setOnClickListener(this);
        topFrame.setElevation(10);
        secondFrame.setElevation(11);
        thirdFrame.setElevation(13);

        icon1_sibling_view.setElevation(1500);
        icon2_child_view.bringToFront();
        //icon2_child_view.getLocationOnScreen(1500);
        icon2_child_view.requestLayout();
        secondFrame.requestLayout();
        Log.d("yuma", "secondFrame.getElevation()"+secondFrame.getElevation());
        Log.d("yuma", "icon2_child_view.getElevation()"+icon2_child_view.getElevation());
        Log.d("yuma", "thirdFrame.getElevation()"+thirdFrame.getElevation());

        Log.d("yuma", "secondFrame.getZ()"+secondFrame.getZ());
        Log.d("yuma", "icon2_child_view.getZ()"+icon2_child_view.getZ());
        Log.d("yuma", "thirdFrame.getZ()"+thirdFrame.getZ());

        Log.d("yuma", "secondFrame.getTranslationZ()"+secondFrame.getTranslationZ());
        Log.d("yuma", "icon2_child_view.getTranslationZ()"+icon2_child_view.getTranslationZ());
        Log.d("yuma", "thirdFrame.getTranslationZ()"+thirdFrame.getTranslationZ());


        //icon2_child_view.setZ(1000);
        //icon2_child_view.setElevation(1000);
        //icon2_child_view.setTranslationZ(1000);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }


    @Override
    public void onClick(View v) {

        TranslateAnimation animation = new TranslateAnimation(
                Animation.ABSOLUTE, thirdFrame.getX(),
                Animation.ABSOLUTE, thirdFrame.getX(),
                Animation.ABSOLUTE, thirdFrame.getY() - thirdFrame.getHeight(),
                Animation.ABSOLUTE, thirdFrame.getY() - thirdFrame.getHeight() - 1500);
        animation.setDuration(4000);
        thirdFrame.startAnimation(animation);
    }
}
