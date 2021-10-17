package com.example.wexhat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;


import com.example.wexhat.Adapter.FragmentAdapter;
import com.example.wexhat.fragment.Fagmenttongxunlu;
import com.example.wexhat.fragment.Fragmentfaxian;
import com.example.wexhat.fragment.Fragmentme;
import com.example.wexhat.fragment.Fragmentmes;
import com.example.wexhat.uitl.MyDrwerlayout;
import com.example.wexhat.uitl.Vparge;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager vp;
    private Fragmentmes fragmentmes;
    private Fragmentme fragmentme;
    private Fragmentfaxian fragmentfaxian;
    private Fagmenttongxunlu fagmenttongxunlu;
    private List<Fragment> fragmentList=new ArrayList<>();
    private FragmentAdapter mFragmentAdapter;
    private TextView title;
    private LinearLayout mes;
    private LinearLayout tongxunlu;
    private LinearLayout faxian;
    private LinearLayout me;
    private static final String TAG = "MainActivity";
    MyDrwerlayout dl;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), fragmentList);
        vp.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        vp.setAdapter(mFragmentAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                View viewById = findViewById(R.id.toolbarlayout);
                switch (position){
                    case 0:
                        if (viewById.getVisibility()!=View.VISIBLE){
                            viewById.setVisibility(View.VISIBLE);
                        }
                        title.setText("微信");
                            changeTextColor(position);
                        Log.d(TAG, "onPageSelected: 1");
                    break;
                    case 1:
                        if (viewById.getVisibility()!=View.VISIBLE){
                            viewById.setVisibility(View.VISIBLE);
                        }
                        title.setText("通讯录");
                        Log.d(TAG, "onPageSelected: ");
                        changeTextColor(position);
                        Log.d(TAG, "onPageSelected: ");
                    break;
                    case 2:

                        if (viewById.getVisibility()!=View.VISIBLE){
                            viewById.setVisibility(View.VISIBLE);
                        }
                        title.setText("发现");
                        changeTextColor(position);
                    break;
                    case 3:
                         viewById.setVisibility(View.GONE);
                        changeTextColor(position);
                        break;
                    default:
                        break;


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    public void init(){
        mes=findViewById(R.id.mes);
        mes.setOnClickListener(this);
        tongxunlu=findViewById(R.id.tongxunlu);
        tongxunlu.setOnClickListener(this);
        faxian=findViewById(R.id.faxian);
        faxian.setOnClickListener(this);
        me=findViewById(R.id.me);
        me.setOnClickListener(this);
        vp=findViewById(R.id.view_p);
        title=findViewById(R.id.title_1);
        fragmentmes=new Fragmentmes(this);
        fragmentme=new Fragmentme();
        fragmentfaxian=new Fragmentfaxian();
        fagmenttongxunlu=new Fagmenttongxunlu();
        fragmentList.add(fragmentmes);
        fragmentList.add(fagmenttongxunlu);
        fragmentList.add(fragmentfaxian);
        fragmentList.add(fragmentme);

    }
    private void changeTextColor(int position) {
        if (position == 0) {
            mes.setBackgroundColor(Color.parseColor("#66CDAA"));
            tongxunlu.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            faxian.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            me.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        } else if (position == 1) {
            mes.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            tongxunlu.setBackgroundColor(Color.parseColor("#66CDAA"));
            faxian.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            me.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        } else if (position == 2) {
            mes.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            tongxunlu.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            faxian.setBackgroundColor(Color.parseColor("#66CDAA"));
            me.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        } else if (position == 3) {
            mes.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            tongxunlu.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            faxian.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            me.setBackgroundColor(Color.parseColor("#66CDAA"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mes:
                vp.setCurrentItem(0, true);
                break;
            case R.id.tongxunlu:
                vp.setCurrentItem(1,true);
                break;
            case R.id.faxian:
                vp.setCurrentItem(2,true);
                break;
            case R.id.me:
                vp.setCurrentItem(3,true);
                break;
        }
    }
    float strat;
    float end;
    MotionEvent event0;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: main"+event0);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                strat = ev.getX();
                event0=ev;
                Log.d(TAG, "start" + strat+"  ev "+event0.getAction());
                break;
            case MotionEvent.ACTION_MOVE:
                end = ev.getX();
                Log.d(TAG, "end " + end);
                float distance = end - strat;
                Log.d(TAG, "滑动距离：" + distance);
                if (distance >0&&vp.getCurrentItem()==0) {
                    Log.d(TAG, "向右滑 "+event0.getAction());
                    Vparge.setCan_vp(false);
//                    dl=MyDrwerlayout.mmyDrwerlayout;
                    Log.d(TAG, "dispatchTouchEvent: dl "+dl);
//                    dl.onTouchEvent(event0);
                } else {
                    Log.d(TAG, "onTouch: 向左滑");
                    Vparge.setCan_vp(true);
//                    vp.onTouchEvent(event0);
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ACTION_UP: "+event0.getAction());
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: main");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }

}