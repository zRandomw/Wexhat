package com.example.wexhat.Adapter;

import android.content.IntentFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wexhat.MainActivity;
import com.example.wexhat.R;
import com.example.wexhat.bean.People;
import com.example.wexhat.uitl.MyDrwerlayout;

import java.util.List;
import java.util.logging.Handler;

public class ReAdapter extends RecyclerView.Adapter<ReAdapter.VeiwHolder> {
    private List<People> peopleList;
    private static final String TAG = "ReAdapter";
    public ReAdapter(List<People> peopleList) {
        this.peopleList = peopleList;
    }
    VeiwHolder holder;
    @NonNull
    @Override

    public ReAdapter.VeiwHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_main_item, parent, false);
        holder = new VeiwHolder(view);
        holder.dl.getdl(holder.dl);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReAdapter.VeiwHolder holder, int position) {
            People people=peopleList.get(position);
            holder.tuxiang.setImageResource(people.getTuxiang());
            holder.name.setText(people.getName());
            holder.time.setText(people.getTime());

            holder.dl.addDrawerListener(new DrawerLayout.DrawerListener() {
                @Override
                public void onDrawerSlide(@NonNull  View drawerView, float slideOffset) {
                    holder.item.setTranslationX((drawerView.getWidth()*slideOffset));
                }

                @Override
                public void onDrawerOpened(@NonNull View drawerView) {

                }

                @Override
                public void onDrawerClosed(@NonNull View drawerView) {

                }

                @Override
                public void onDrawerStateChanged(int newState) {

                }
            });
            holder.del.setOnClickListener(v->{
                notifyDataSetChanged();
                peopleList.remove(position);
                Log.d(TAG, "onBindViewHolder: index:"+position);
                Log.d(TAG, "onBindViewHolder: "+peopleList.size());

            });
            holder.end.setOnClickListener(v->{
                notifyDataSetChanged();
                peopleList.add(peopleList.size()-1,peopleList.remove(position));
            });
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }
//    float strat;
//    float end;
//    @Override
//    public boolean onTouch(View v, MotionEvent ev) {
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                strat = ev.getX();
//                Log.d(TAG, "start" + strat);
//                break;
//            case MotionEvent.ACTION_UP:
//                end = ev.getX();
//                Log.d(TAG, "" + end);
//                float distance = end - strat;
//                Log.d(TAG, "滑动距离：" + distance);
//                if (distance > 0) {
//                    Log.d(TAG, "向左滑");
////                    setCan_vp(false);
//                    holder.dl.openDrawer(GravityCompat.START);
//                    return true;
//                } else {
//                    Log.d(TAG, "onTouch: 向右滑");
////                    setCan_vp(true);
//                }
//                break;
//
//        }
//        return false;
//    }


    public class VeiwHolder extends RecyclerView.ViewHolder{
        public MyDrwerlayout dl;
        public LinearLayout item;
        public ImageView tuxiang;
        public TextView name;
        public TextView time;
        public TextView end;
        public TextView del;
        public VeiwHolder(@NonNull  View itemView) {
            super(itemView);
            dl=itemView.findViewById(R.id.dl);
            Log.d(TAG, "VeiwHolder: "+dl);
            item=itemView.findViewById(R.id.item);
            tuxiang=itemView.findViewById(R.id.tuxiang);
            name= itemView.findViewById(R.id.name);
            time=itemView.findViewById(R.id.time);
            end=itemView.findViewById(R.id.end);
            del=itemView.findViewById(R.id.del);
        }
    }
}
