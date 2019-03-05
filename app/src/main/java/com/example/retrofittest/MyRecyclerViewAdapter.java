package com.example.retrofittest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    List<Hero> heroList;
    Context mCtx;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context mCtx, List<Hero> data) {
        this.mCtx = mCtx;
        this.heroList = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hero hero = heroList.get(position);
        Glide.with(mCtx)
                .load(hero.getImageurl())
                .into(holder.myImageView);
        holder.myTextView.setText(hero.getName());
        holder.myTextView2.setText(hero.getRealname());

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return heroList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        TextView myTextView2;
        ImageView myImageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.HeroName);
            myTextView2 = itemView.findViewById(R.id.HeroRealName);
            myImageView = itemView.findViewById(R.id.imageView);
        }

    }
}