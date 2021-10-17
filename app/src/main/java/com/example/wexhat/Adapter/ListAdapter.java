package com.example.wexhat.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wexhat.R;
import com.example.wexhat.bean.People;

import java.util.List;

public class ListAdapter extends ArrayAdapter<People> {
    int resource;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<People> objects) {
        super(context, resource, objects);
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        People people = getItem(position);
     @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        ImageView img = view.findViewById(R.id.toxunluimg);
        TextView name=view.findViewById(R.id.tname);
        TextView t_a=view.findViewById(R.id.T_A);
        img.setImageResource(people.getTuxiang());
        name.setText(people.getName());
        t_a.setText(people.getT_a());
        return view;
    }
}
