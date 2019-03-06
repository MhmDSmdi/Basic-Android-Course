package com.blucode.mhmd.section3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blucode.mhmd.section3.Adapter.SongCardAdapter;
import com.blucode.mhmd.section3.data.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Song> songs;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        songs = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_main_songs);
        fetchSongs();
        SongCardAdapter adapter = new SongCardAdapter(this, songs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fetchSongs() {
        songs.add(new Song("Song1", "This is an amazing Music", R.drawable.img2));
        songs.add(new Song("Song2", "This is an amazing Music", R.drawable.img3));
        songs.add(new Song("Song3", "This is an amazing Music", R.drawable.img4));
        songs.add(new Song("Song4", "This is an amazing Music", R.drawable.img5));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar_song, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_song_profile:
                Toast.makeText(MainActivity.this, "Profile Clicked", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_song_setting:
                Toast.makeText(MainActivity.this, "Setting Clicked", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
