package com.example.movieapp.adapter;

import android.widget.ImageView;

import com.example.movieapp.model.Movie;

public interface MovieItemClickListener {
    // cta can ImageView de thuc hien chia se animation giua 2 activity
    void onMovieClick(Movie movie, ImageView movieImageView);
}
