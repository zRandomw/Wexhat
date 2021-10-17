package com.example.wexhat.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.wexhat.Adapter.ReAdapter;
import com.example.wexhat.MainActivity;
import com.example.wexhat.R;
import com.example.wexhat.bean.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Fragmentmes extends Fragment implements View.OnTouchListener {
    private static final String TAG = "Fragmentmes";
    private RecyclerView recyclerView;
    private View view;
    private SwipeRefreshLayout refreshLayout;
    private List<People> peopleList;
    ReAdapter reAdapter ;
    public MainActivity mainActivity;
    private String [] data={"xxx","汤姆","邪龙邪神","广西表妹","远古狗皇","日地邪神","洗澡邪神","远古邪神","骚俊天帝","天阳圣王","坨子战神"};
    private int[] img={R.drawable.mi,R.drawable.nitian,R.drawable.chenlong,R.drawable.biaomei,R.drawable.p_2,R.drawable.ridi,R.drawable.ahui,R.drawable.saojun,R.drawable.djy,R.drawable.tuozijie,R.drawable.tuozijie};
    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mes, container, false);
        init(view);
        return view;
    }
    @SuppressLint("ClickableViewAccessibility")
    private void init(View view){
        refreshLayout=view.findViewById(R.id.swip_refresh);
        refreshLayout.setOnRefreshListener(this::refreshpeople);
        recyclerView=view.findViewById(R.id.re_view);
        peopleList=new ArrayList<>();
        for (int i=0;i< data.length;i++){
            peopleList.add(new People(img[i],data[i],"7:00"));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
         reAdapter=new ReAdapter(peopleList);
        recyclerView.setAdapter(reAdapter);
        recyclerView.setOnTouchListener(this);

    }

    private void refreshpeople() {
        new Thread(()->{
            try {
                Thread.sleep(2000);

            }catch (Exception e){
                e.printStackTrace();
            }
            mainActivity.runOnUiThread(()->{
                    initPelple();
                    reAdapter.notifyDataSetChanged();
                    refreshLayout.setRefreshing(false);
            });
        }).start();

    }

    private void initPelple() {
        Random random = new Random();
        peopleList.clear();
        for (int i=0;i< data.length;i++){
            int a = random.nextInt(11);
            peopleList.add(new People(img[a],data[a],"7:00"));
        }
//        recyclerView.setAdapter(new ReAdapter(peopleList));
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "onTouch: mes");

        return false;
    }

    public Fragmentmes(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}
