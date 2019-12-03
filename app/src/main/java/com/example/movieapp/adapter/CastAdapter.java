package com.example.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.model.Cast;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.ViewHolder> {

    Context context;
    List<Cast> mData;

    public CastAdapter(Context context, List<Cast> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_cast, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /*Cast cast = mData.get(position);
        holder.imgCast.setImageResource(cast.getImgLink());*/

        Glide.with(context).load(mData.get(position).getImgLink()).into(holder.imgCast);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCast;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCast = itemView.findViewById(R.id.imgCast);
        }
    }
}
