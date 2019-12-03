package com.example.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.movieapp.model.Movie;
import com.example.movieapp.R;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<Movie> mData;
    MovieItemClickListener movieItemClickListener;

    public MovieAdapter(Context context, List<Movie> mData, MovieItemClickListener listener) {
        this.context = context;
        this.mData = mData;
        movieItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.iteam_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = mData.get(position);
        holder.itemMovie.setImageResource(movie.getThumnail());
        holder.iteamMovieTitle.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemMovie;
        TextView iteamMovieTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemMovie = itemView.findViewById(R.id.itemMovie);
            iteamMovieTitle = itemView.findViewById(R.id.iteamMovieTitle);

            //
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieItemClickListener.onMovieClick(mData.get(getAdapterPosition()), itemMovie);
                }
            });
        }
    }
}
