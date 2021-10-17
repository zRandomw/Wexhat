package com.example.wexhat.uitl;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.nio.file.Path;
public class SideBar extends View {
    private static final String TAG = "SideBar";
    public SideBar(Context context) {
        super(context);
    }
    public SideBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public SideBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    // 触摸事件
    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    private String[] alphabet = {
            "⭐","A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"};
    private int choose = -1;// 选中

    private Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       int ViewHeight=getHeight();
       int ViewWidth=getWidth();
       int singleHeight=ViewHeight/alphabet.length;
       for (int i=0;i<alphabet.length;i++){
           paint.setColor(Color.rgb(34,66,99));
           paint.setTypeface(Typeface.DEFAULT);
           paint.setTextSize(50);
           paint.setAntiAlias(true);//抗锯齿
           if (choose==i){
               Log.d(TAG, "onDraw: choose");

               paint.setTextSize(65);//因为是在循环里面每一个字母都单独绘制
               paint.setFakeBoldText(true);
               paint.setAntiAlias(true);
           }
           float x=ViewWidth/2-paint.measureText(alphabet[i])/2;
           float y=singleHeight*i+singleHeight;
           canvas.drawText(alphabet[i],x,y,paint);
           paint.reset();
       }
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float y = event.getY();// 点击y坐标
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
//        触摸到哪一个字体
        final int c = (int) (y / getHeight() * alphabet.length);
        // 点击y坐标所占总高度的比例*b数组的长度就等于点击b中的个数.
        switch (action) {
//            没进行操作时 右边导航栏的状态
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.parseColor("#00000000"));
                choose =-1;// up 时是否显示选中颜色
                invalidate();
                if (listener != null) {
                    listener.noTouchLetter();
                }
                break;
//                向下滑动时
            case MotionEvent.ACTION_DOWN:
//                向下滑动时 背景变色
                choose=c;
                invalidate();
                setBackgroundColor(Color.rgb(255,182,193));
            case MotionEvent.ACTION_MOVE:
                choose=c;
                invalidate();
            default:
                setAlpha((float) 0.7);//设置透明度
                if (choose == c) {
                    if (c >= 0 && c < alphabet.length) {
                        if (listener != null) {
                            listener.onTouchingLetterChanged(alphabet[c]);
                        }
                        invalidate();//使整个窗口客户区无效，此时就需要重绘，也就是重新调用onDraw
                    }
                }
                break;
        }
        return true;
    }
    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }
    public interface OnTouchingLetterChangedListener {
         void onTouchingLetterChanged(String s);
         void noTouchLetter();
    }
}
