package com.example.movieapp.utils;

import com.example.movieapp.R;
import com.example.movieapp.model.Movie;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Movie> getPopularMovie(){
        //RecyclerView
        List<Movie> listMovie = new ArrayList<>();
        listMovie.add(new Movie("Movie 1", R.drawable.movie1, R.drawable.slide2));
        listMovie.add(new Movie("Movie 2", R.drawable.movie2, R.drawable.slide2));
        listMovie.add(new Movie("Movie 3", R.drawable.movie3, R.drawable.slide2));
        listMovie.add(new Movie("Movie 4", R.drawable.movie4, R.drawable.slide2));
        listMovie.add(new Movie("Movie 5", R.drawable.movie5, R.drawable.slide2));
        listMovie.add(new Movie("Movie 4", R.drawable.movie4, R.drawable.slide2));
        listMovie.add(new Movie("Movie 5", R.drawable.movie5, R.drawable.slide2));
        return listMovie;
    }

    public static List<Movie> getWeekMovie(){
        List<Movie> listMovie = new ArrayList<>();
        listMovie.add(new Movie("Movie 5", R.drawable.movie5, R.drawable.slide2));
        listMovie.add(new Movie("Movie 4", R.drawable.movie4, R.drawable.slide2));
        listMovie.add(new Movie("Movie 5", R.drawable.movie5, R.drawable.slide2));
        listMovie.add(new Movie("Movie 1", R.drawable.movie1, R.drawable.slide2));
        listMovie.add(new Movie("Movie 2", R.drawable.movie2, R.drawable.slide2));
        listMovie.add(new Movie("Movie 3", R.drawable.movie3, R.drawable.slide2));
        listMovie.add(new Movie("Movie 4", R.drawable.movie4, R.drawable.slide2));
        return listMovie;
    }
}
