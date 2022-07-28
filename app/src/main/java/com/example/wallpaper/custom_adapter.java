package com.example.wallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class custom_adapter extends RecyclerView.Adapter<custom_adapter.Wallpaper_holder> {

    private final ArrayList<String> list;

    public custom_adapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private Context context;
    @NonNull
    @Override
    public Wallpaper_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.custom_layout,parent,false);


        return new Wallpaper_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Wallpaper_holder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.imageView);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,fullImageActivity.class);
            intent.putExtra("image",list.get(position));
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Wallpaper_holder extends RecyclerView.ViewHolder {
ImageView imageView ;

        public Wallpaper_holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.images);
        }
    }}
