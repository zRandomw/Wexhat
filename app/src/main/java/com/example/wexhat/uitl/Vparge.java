package com.example.wexhat.uitl;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class Vparge extends ViewPager {

    private static final String TAG = "vparge";
    private static boolean can_vp=true;

    public static void setCan_vp(boolean a) {
        can_vp = a;
    }

    public Vparge(@NonNull  Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: vp");
        Log.d(TAG, "can "+can_vp);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onTouchEvent: vp"+ev.getAction());

        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: vp"+ev.getAction());
        return can_vp&&super.onInterceptTouchEvent(ev);
    }

}
