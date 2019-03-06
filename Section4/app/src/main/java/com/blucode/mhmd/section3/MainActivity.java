package com.blucode.mhmd.section3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.blucode.mhmd.section3.Adapter.SongCardAdapter;
import com.blucode.mhmd.section3.data.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
