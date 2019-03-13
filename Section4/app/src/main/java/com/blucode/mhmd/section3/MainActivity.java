package com.blucode.mhmd.section3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blucode.mhmd.section3.Adapter.SongCardAdapter;
import com.blucode.mhmd.section3.data.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Song> songs;
    private Toolbar toolbar;
    private SongCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        songs = new ArrayList<>();
        swipeRefreshLayout = findViewById(R.id.swipref_main);
        recyclerView = findViewById(R.id.recycler_main_songs);
        fetchSongs();
        adapter = new SongCardAdapter(this, songs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        songs.remove(viewHolder.getAdapterPosition());
                        adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "List Updated", Toast.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

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


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        Log.wtf("ttest", "onCreateContextMenu: ");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_context_share:
                Toast.makeText(MainActivity.this, "Share Clicked", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_context_remove:
                Toast.makeText(MainActivity.this, "Remove Clicked", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_context_info:
                Toast.makeText(MainActivity.this, "Info Clicked", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
