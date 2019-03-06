package com.blucode.mhmd.section3.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blucode.mhmd.section3.R;
import com.blucode.mhmd.section3.data.Song;
import com.bumptech.glide.Glide;

import java.util.List;

public class SongCardAdapter extends RecyclerView.Adapter<SongCardAdapter.ViewHolder> {

    private List<Song> songList;
    private Context mContext;

    public SongCardAdapter(Context mContext, List<Song> songList) {
        this.songList = songList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_song_preview, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Song song = songList.get(i);
        viewHolder.name.setText(song.getName());
        viewHolder.description.setText(song.getDescription());
        Glide.with(mContext).load(song.getImgDrawable()).into(viewHolder.cover);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView name, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.img_songCard_cover);
            name = itemView.findViewById(R.id.txt_songCard_musicName);
            description = itemView.findViewById(R.id.txt_songCard_musicDescription);
        }
    }
}
