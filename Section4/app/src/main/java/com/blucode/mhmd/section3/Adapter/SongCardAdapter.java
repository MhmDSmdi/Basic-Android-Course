package com.blucode.mhmd.section3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blucode.mhmd.section3.R;
import com.blucode.mhmd.section3.SongActivity;
import com.blucode.mhmd.section3.data.Constant;
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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Song song = songList.get(i);
        viewHolder.name.setText(song.getName());
        viewHolder.description.setText(song.getDescription());
        Glide.with(mContext).load(song.getImgDrawable()).into(viewHolder.cover);

        if (song.isFavorite())
            Glide.with(mContext).load(R.drawable.ic_favorite_on).into(viewHolder.favorite);
        else
            Glide.with(mContext).load(R.drawable.ic_favorite_off).into(viewHolder.favorite);

        viewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.setFavorite(!song.isFavorite());
                if (song.isFavorite())
                    Glide.with(mContext).load(R.drawable.ic_favorite_on).into(viewHolder.favorite);
                else
                    Glide.with(mContext).load(R.drawable.ic_favorite_off).into(viewHolder.favorite);
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SongActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean(Constant.EXTRA_IS_FAVORITE, song.isFavorite());
                bundle.putString(Constant.EXTRA_SONG_NAME, song.getName());
                bundle.putString(Constant.EXTRA_SONG_DESCRIPTION, song.getDescription());
                bundle.putInt(Constant.EXTRA_SONG_COVER, song.getImgDrawable());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cover, favorite;
        TextView name, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.img_songCard_cover);
            favorite = itemView.findViewById(R.id.ic_songCard_favorite);
            name = itemView.findViewById(R.id.txt_songCard_musicName);
            description = itemView.findViewById(R.id.txt_songCard_musicDescription);
        }
    }
}
