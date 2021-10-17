package com.example.wexhat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wexhat.Adapter.ListAdapter;
import com.example.wexhat.R;
import com.example.wexhat.bean.People;
import com.example.wexhat.uitl.SideBar;

import java.util.ArrayList;
import java.util.List;

public class Fagmenttongxunlu extends Fragment {
    public ListView listView;
    private SideBar sideBar;
    private TextView textViewDialog;
    public List<People> peopleList=new ArrayList<>();
    private String [] data={"xxx","汤姆","邪龙邪神","广西表妹","远古狗皇","日地邪神","洗澡邪神","远古邪神","骚俊天帝","天阳圣王","坨子战神"};
    private String[] alphabet= {
            "","A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"};
    private int[] img={R.drawable.mi,R.drawable.nitian,R.drawable.chenlong,R.drawable.biaomei,R.drawable.p_2,R.drawable.ridi,R.drawable.ahui,R.drawable.saojun,R.drawable.djy,R.drawable.tuozijie,R.drawable.tuozijie};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);
        sideBar= view.findViewById(R.id.Sidebar);
        textViewDialog= view.findViewById(R.id.textViewDialog);
        init(view);
        setTextViewDialog();
        return view;
    }
    public void init(View view){
        listView=view.findViewById(R.id.fragment2_list);

            for (int i=0;i< data.length;i++){
                peopleList.add(new People(data[i],alphabet[i],img[i]));
            }
        listView.setAdapter(new ListAdapter(getActivity(),R.layout.list_view,peopleList));

    }
    private void setTextViewDialog(){
//        定义的一个内部接口
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                textViewDialog.setVisibility(View.VISIBLE);
                textViewDialog.setText(s);
                for (int i=0;i<peopleList.size();i++){
                    if (peopleList.get(i).getT_a().equals(s)){
                        listView.setSelection(i);//使listview滑动到选择的项
                        return;
                    }
                }
            }
            //            没选择字母时 隐藏 textView
            @Override
            public void noTouchLetter() {
                textViewDialog.setVisibility(View.GONE);
            }
        });
    }
}
