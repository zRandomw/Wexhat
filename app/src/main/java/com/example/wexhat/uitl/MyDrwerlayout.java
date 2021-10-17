package com.example.wexhat.uitl;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.wexhat.R;


public class MyDrwerlayout extends DrawerLayout{
    private static final String TAG = "MyDrwerlayout";
    private boolean a=true;
    public static MyDrwerlayout mmyDrwerlayout;
    public void setA(boolean a) {
        this.a = a;
    }

    public MyDrwerlayout(@NonNull  Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: dw");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onTouchEvent: dw"+ev.getAction());

        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: dw"+ev.getAction());

        return super.onInterceptTouchEvent(ev);
    }
public void getdl(MyDrwerlayout myDrwerlayout){
        mmyDrwerlayout=myDrwerlayout;
    Log.d(TAG, "getdl: 获取实例"+mmyDrwerlayout);
}
}
