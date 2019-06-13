package com.example.dong.kaoshi10.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dong.kaoshi10.R;
import com.example.dong.kaoshi10.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class RlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Bean> list;

    public RlvAdapter(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
       if (position%2==0){
           return 0;
       }else {
           return 1;
       }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        if (i==0){
            View inflate = from.inflate(R.layout.item, null);
            return new VH1(inflate);
        }else {
            View inflate = from.inflate(R.layout.item2, null);
            return new VH2(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType==0){
            VH1 vh1= (VH1) viewHolder;
            vh1.tv.setText(list.get(i).getTitle());
            Glide.with(context).load(list.get(i).getUrl()).into(vh1.img);
        }else {
            VH2 vh2= (VH2) viewHolder;
            vh2.tv.setText(list.get(i).getTitle());
            Glide.with(context).load(list.get(i).getUrl()).into(vh2.img);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onCLick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VH1 extends RecyclerView.ViewHolder{
private TextView tv;
private ImageView img;
        public VH1(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            img=itemView.findViewById(R.id.img);
        }
    }
    class VH2 extends RecyclerView.ViewHolder{
        private TextView tv;
        private ImageView img;
        public VH2(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            img=itemView.findViewById(R.id.img);
        }
    }
    public interface OnClickListener{
        void onCLick(int position);
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
