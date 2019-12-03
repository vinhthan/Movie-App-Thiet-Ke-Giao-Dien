package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;
import com.example.movieapp.model.Movie;
import com.example.movieapp.adapter.MovieAdapter;
import com.example.movieapp.adapter.MovieItemClickListener;
import com.example.movieapp.R;
import com.example.movieapp.model.Slide;
import com.example.movieapp.adapter.SlidePageAdapter;
import com.example.movieapp.utils.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> listSlides;
    private ViewPager slidePage;
    private SlidePageAdapter adapter;
    private TableLayout indicator;

    //private List<Movie> listMovie;
    private RecyclerView recyclerView, recyclerViewMovieWeek;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initSlider();
        initPopularMovies();
        initWeekMovie();
    }

    private void initWeekMovie() {
        MovieAdapter weekMovieAdapter = new MovieAdapter(this, DataSource.getWeekMovie(), this);
        recyclerViewMovieWeek.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewMovieWeek.setAdapter(weekMovieAdapter);
    }

    private void initPopularMovies() {
        /*//RecyclerView
        listMovie = new ArrayList<>();
        listMovie.add(new Movie("Movie 1", R.drawable.movie1, R.drawable.slide2));
        listMovie.add(new Movie("Movie 2", R.drawable.movie2, R.drawable.slide2));
        listMovie.add(new Movie("Movie 3", R.drawable.movie3));
        listMovie.add(new Movie("Movie 4", R.drawable.movie4));
        listMovie.add(new Movie("Movie 5", R.drawable.movie5));
        listMovie.add(new Movie("Movie 4", R.drawable.movie4));
        listMovie.add(new Movie("Movie 5", R.drawable.movie5));*/

        movieAdapter = new MovieAdapter(this, DataSource.getPopularMovie(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(movieAdapter);
    }

    private void initSlider() {
        //list slide
        listSlides = new ArrayList<>();

        listSlides.add(new Slide(R.drawable.slide2, "Slide title \nmore text here"));
        listSlides.add(new Slide(R.drawable.slide3, "Slide title \nmore text here"));
        listSlides.add(new Slide(R.drawable.slide2, "Slide title \nmore text here"));
        listSlides.add(new Slide(R.drawable.slide3, "Slide title \nmore text here"));

        adapter = new SlidePageAdapter(this, listSlides);
        slidePage.setAdapter(adapter);

        //setup time
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SlideTime(),
                3000, 4000);//img dau 3s, img sau 4s
    }

    private void initView() {
        slidePage = findViewById(R.id.slidePage);
        indicator = findViewById(R.id.indicator);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewMovieWeek = findViewById(R.id.recyclerViewMovieWeek);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        //tai day cta se gui thong tin toi detail activity
        //cung nhu cta se tao di chuyen animation giua 2 activity

        Toast.makeText(this, "item clicked: " + movie.getTitle(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
        intent.putExtra("imgURL", movie.getThumnail());
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        //startActivity(intent);

        //tao animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                movieImageView, "shareName");
        startActivity(intent, options.toBundle());
    }

    class SlideTime extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slidePage.getCurrentItem()<listSlides.size()-1){
                        slidePage.setCurrentItem(slidePage.getCurrentItem()+1);
                    }else {
                        slidePage.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
