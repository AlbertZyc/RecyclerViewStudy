package com.study.zyc.recyclestudy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter01 extends RecyclerView.Adapter<RecyclerAdapter01.ViewHolder> {
    private ArrayList<String> datas;
    public RecyclerAdapter01(ArrayList<String> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerAdapter01.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_01_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapter01.ViewHolder viewHolder, final int i) {
        viewHolder.item_text.setText(datas.get(i));
        viewHolder.item_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick01","点击了"+ i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_text = itemView.findViewById(R.id.tv_item);
        }
    }
}
