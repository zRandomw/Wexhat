package com.example.wexhat.uitl;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

public class Myreview extends RecyclerView {
    private static final String TAG = "Myreview";
    private boolean a=false;
    public Myreview(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: re"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.d(TAG, "onTouchEvent: re"+e.getAction());
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.d(TAG, "onInterceptTouchEvent: re"+e.getAction());
        return super.onInterceptTouchEvent(e);
    }

}
