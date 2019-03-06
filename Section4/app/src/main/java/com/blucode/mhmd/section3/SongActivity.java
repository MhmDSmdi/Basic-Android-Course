package com.blucode.mhmd.section3;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blucode.mhmd.section3.data.Constant;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class SongActivity extends Activity {

    private TextView songName, songDescription;
    private CircleImageView imgCover;
    private ImageView back, favorite;
    private boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_activity);
        Bundle bundle = getIntent().getExtras();
        songName = findViewById(R.id.txt_song_musicName);
        songDescription = findViewById(R.id.txt_song_musicDescription);
        imgCover = findViewById(R.id.img_song_cover);
        back = findViewById(R.id.ic_song_back);
        favorite = findViewById(R.id.ic_song_favorite);
        songDescription.setText(bundle.getString(Constant.EXTRA_SONG_DESCRIPTION));
        songName.setText(bundle.getString(Constant.EXTRA_SONG_NAME));
        Glide.with(this).load(bundle.getInt(Constant.EXTRA_SONG_COVER)).into(imgCover);
        Glide.with(this).load(bundle.getBoolean(Constant.EXTRA_IS_FAVORITE) ? R.drawable.ic_favorite_on : R.drawable.ic_favorite_off).into(favorite);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
