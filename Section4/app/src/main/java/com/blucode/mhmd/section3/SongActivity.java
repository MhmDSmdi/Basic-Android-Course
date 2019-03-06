package com.blucode.mhmd.section3;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blucode.mhmd.section3.data.Constant;
import com.blucode.mhmd.section3.data.Song;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class SongActivity extends AppCompatActivity {

    private TextView songName, songDescription;
    private CircleImageView imgCover;
    private ImageView back, favorite;
    private Toolbar toolbar;
    private boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_activity);
        Bundle bundle = getIntent().getExtras();
        toolbar = findViewById(R.id.song_toolbar);
        setSupportActionBar(toolbar);
        songName = findViewById(R.id.txt_song_musicName);
        songDescription = findViewById(R.id.txt_song_musicDescription);
        imgCover = findViewById(R.id.img_song_cover);
        back = findViewById(R.id.ic_song_back);
        favorite = findViewById(R.id.ic_song_favorite);
        songDescription.setText(bundle.getString(Constant.EXTRA_SONG_DESCRIPTION));
        songName.setText(bundle.getString(Constant.EXTRA_SONG_NAME));
        Glide.with(this).load(bundle.getInt(Constant.EXTRA_SONG_COVER)).into(imgCover);
        Glide.with(this).load(bundle.getBoolean(Constant.EXTRA_IS_FAVORITE) ? R.drawable.ic_favorite_on : R.drawable.ic_favorite_off).into(favorite);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFavorite = !isFavorite;
                Glide.with(SongActivity.this).load(isFavorite ? R.drawable.ic_favorite_on : R.drawable.ic_favorite_off).into(favorite);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
