package com.example.volly_recyclerview;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Adapater extends RecyclerView.Adapter<Adapater.ViewHolder> {
    private ArrayList<MyListData> listDataList;

    public Adapater(ArrayList<MyListData> listDataList) {
        this.listDataList = listDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v =layoutInflater.inflate(R.layout.data_in_rv,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName.setText(listDataList.get(position).getName());
        holder.mGender.setText(listDataList.get(position).getGender());
    }

    @Override
    public int getItemCount() {
           return listDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName,mGender;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.NameData);
            mGender = itemView.findViewById(R.id.GenderData);
        }
    }
}
