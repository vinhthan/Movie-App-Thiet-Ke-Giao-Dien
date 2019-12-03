package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.adapter.CastAdapter;
import com.example.movieapp.model.Cast;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView movieThumnailImg, movieCoverImg;
    private TextView txvDescription, txvTitle;
    private ImageView imgPlay;
    private RecyclerView recyclerViewDetail;
    private CastAdapter adapter;

    private List<Cast> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //initView
        initView();
        //setup list cast
        setupRecyclerViewCast();
    }

    private void initView(){

        movieThumnailImg = findViewById(R.id.imgDetailMovie);
        movieCoverImg = findViewById(R.id.imgDetailMovie);
        txvDescription = findViewById(R.id.detailMovieDescription);
        txvTitle = findViewById(R.id.detailMovieTitle);
        imgPlay = findViewById(R.id.imgPlay);
        recyclerViewDetail = findViewById(R.id.recyclerViewDetail);

        //nhan dlieu tu MainActivity
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imgCover = getIntent().getExtras().getInt("imgCover");

        Glide.with(this).load(imageResourceId).into(movieThumnailImg);
        movieThumnailImg.setImageResource(imageResourceId);
        Glide.with(this).load(imgCover).into(movieCoverImg);

        txvTitle.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);

        //animation
        movieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
        imgPlay.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));

        //click play
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieDetailActivity.this, MoviePlayerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupRecyclerViewCast() {
        recyclerViewDetail = findViewById(R.id.recyclerViewDetail);

        mdata = new ArrayList<>();
        mdata.add(new Cast("Cast 1", R.drawable.cast1));
        mdata.add(new Cast("Cast 2", R.drawable.cast2));
        mdata.add(new Cast("Cast 3", R.drawable.cast3));
        mdata.add(new Cast("Cast 4", R.drawable.cast4));
        mdata.add(new Cast("Cast 5", R.drawable.cast5));

        adapter = new CastAdapter(this, mdata);
        recyclerViewDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewDetail.setAdapter(adapter);
    }
}
