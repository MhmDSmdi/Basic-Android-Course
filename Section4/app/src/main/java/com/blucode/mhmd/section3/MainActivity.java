package com.blucode.mhmd.section3;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.blucode.mhmd.section3.Adapter.BottomSheetItemListener;
import com.blucode.mhmd.section3.Adapter.OnPlaylistListener;
import com.blucode.mhmd.section3.Adapter.PlayListAdapter;
import com.blucode.mhmd.section3.Adapter.SongCardAdapter;
import com.blucode.mhmd.section3.data.PlayList;
import com.blucode.mhmd.section3.data.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomSheetItemListener, OnPlaylistListener {

    private RecyclerView songRecyclerView, playlistRecyclerView;
    private List<Song> songs;
    private List<PlayList> playLists;
    private Toolbar toolbar;
    private PlayListAdapter playListAdapter;
    private SongCardAdapter songAdapter;
    private TextSwitcher bottomSheetTitle;
    private LinearLayout bottomNav;
    private BottomSheetBehavior sheetBehavior;
    private String title;
    private boolean isExpanded = true;
    private String textToShow[] = {"PlayLists", "Select One of them"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setTitleTextColor(getColor(R.color.white));
        }
        getSupportActionBar().setTitle("Empty Playlist");
        songs = new ArrayList<>();
        playLists = new ArrayList<>();
        playlistRecyclerView = findViewById(R.id.recycler_bottomsheet_playlist);
        songRecyclerView = findViewById(R.id.recycler_main_songs);
        fetchSongs();
        fetchPlayList();
        bottomNav = findViewById(R.id.bottom_nav);
        bottomSheetTitle = findViewById(R.id.txt_bottom_nav_title);
        bottomSheetTitle.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                TextView t = new TextView(MainActivity.this);
                t.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL);
                t.setTextSize(18);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    t.setTextColor(getColor(R.color.white));
                }
                return t;
            }
        });
        bottomSheetTitle.setText(textToShow[1]);
        bottomSheetTitle.setInAnimation(this, android.R.anim.slide_in_left);
        bottomSheetTitle.setOutAnimation(this, android.R.anim.slide_out_right);
        sheetBehavior = BottomSheetBehavior.from(bottomNav);
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        songAdapter = new SongCardAdapter(this, songs, this);
        playListAdapter = new PlayListAdapter(playLists, this, this);
        playlistRecyclerView.setAdapter(playListAdapter);
        playlistRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        songRecyclerView.setAdapter(songAdapter);
        songRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        songs.remove(viewHolder.getAdapterPosition());
                        songAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(songRecyclerView);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        if (!isExpanded) {
                            bottomSheetTitle.setText(textToShow[1]);
                            isExpanded = true;
                        }
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        if (isExpanded) {
                            bottomSheetTitle.setText(textToShow[0]);
                            isExpanded = false;
                        }
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    private void fetchPlayList() {
        List<Song> songs1 = new ArrayList<>();
        songs1.add(new Song("Song1", "This is an amazing Music", R.drawable.img2));
        songs1.add(new Song("Song3", "This is an amazing Music", R.drawable.img5));
        playLists.add(new PlayList("My Playlist", songs1, 5, R.drawable.img8));

        List<Song> songs2 = new ArrayList<>();
        songs2.add(new Song("ImagineDragons", "This is an amazing Music", R.drawable.img6));
        songs2.add(new Song("LinkinPark", "This is an amazing Music", R.drawable.img1));
        songs2.add(new Song("Sting", "This is an amazing Music", R.drawable.img3));
        playLists.add(new PlayList("My Favorite", songs2, 7, R.drawable.img7));

        List<Song> songs3 = new ArrayList<>();
        songs3.add(new Song("Habib", "This is an amazing Music", R.drawable.img1));
        songs3.add(new Song("Shabpare", "This is an amazing Music", R.drawable.img4));
        songs3.add(new Song("Siavash", "This is an amazing Music", R.drawable.img2));
        songs3.add(new Song("Shohre", "This is an amazing Music", R.drawable.img5));
        songs3.add(new Song("Gugush", "This is an amazing Music", R.drawable.img3));
        playLists.add(new PlayList("My Nostalgia Music", songs3, 10, R.drawable.img4));

    }

    private void fetchSongs() {
        songs.add(new Song("Song1", "This is an amazing Music", R.drawable.img2));
        songs.add(new Song("Song2", "This is an amazing Music", R.drawable.img3));
        songs.add(new Song("Song3", "This is an amazing Music", R.drawable.img4));
        songs.add(new Song("Song4", "This is an amazing Music", R.drawable.img5));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_song_profile:
                Toast.makeText(MainActivity.this, "Profile Clicked", Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_song_setting:
                Toast.makeText(MainActivity.this, "Setting Clicked", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar_song, menu);
        return true;
    }

    @Override
    public void onShareClicked(int pos) {
        Toast.makeText(this, "Item " + pos + " Shared", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRemoveClicked(int pos) {
        songs.remove(pos);
        songAdapter.notifyItemRemoved(pos);
    }

    @Override
    public void onInfoClicked(int pos) {
        Toast.makeText(this, "Item " + pos + " Infoed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onReportClicked(int pos) {
        Toast.makeText(this, "Item " + pos + " Reported", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(int pos) {
        songs.clear();
        songs.addAll(playLists.get(pos).getSongs());
        title = playLists.get(pos).getName();
        getSupportActionBar().setTitle(title);
        songAdapter.notifyDataSetChanged();
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onLongClick(int pos) {

    }
}
