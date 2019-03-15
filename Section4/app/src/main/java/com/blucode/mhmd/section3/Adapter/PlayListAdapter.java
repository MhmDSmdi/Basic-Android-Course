package com.blucode.mhmd.section3.Adapter;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blucode.mhmd.section3.R;
import com.blucode.mhmd.section3.data.PlayList;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.PlayListHolder> {
    private List<PlayList> playLists;
    private Context mContext;
    private long[] mVibratePattern = new long[]{0,30};
    private OnPlaylistListener listener;

    public PlayListAdapter(List<PlayList> playLists, Context mContext, OnPlaylistListener listener) {
        this.playLists = playLists;
        this.mContext = mContext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlayListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PlayListHolder(LayoutInflater.from(mContext).inflate(R.layout.card_bottomsheet_playlist, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlayListHolder playListHolder, final int i) {
        PlayList item = playLists.get(i);
        Glide.with(mContext).load(item.getImg()).into(playListHolder.cover);
        playListHolder.name.setText(item.getName());
        StringBuilder num = new StringBuilder();
        num.append(item.getSizeOfPlayList());
        num.append(" songs, ");
        num.append(item.getTime() + " hours");
        playListHolder.number.setText(num.toString());
//        if (item.isFavorite())
//            Glide.with(mContext).load(R.drawable.ic_favorite_on).into(playListHolder.favorite);
//        else
//            Glide.with(mContext).load(R.drawable.ic_favorite_off).into(playListHolder.favorite);
        playListHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(i);
            }
        });

        playListHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongClick(i);
                Vibrator vibrator = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(mVibratePattern, -1);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return playLists.size();
    }

    public class PlayListHolder extends RecyclerView.ViewHolder {
        CircleImageView cover;
        TextView name, number;
        ImageView play, info, favorite;
        public PlayListHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_bottomsheet_playlist_name);
            cover = itemView.findViewById(R.id.img_bottomsheet_card_playlist);
            number = itemView.findViewById(R.id.txt_bottomsheet_number_songs);
            play = itemView.findViewById(R.id.img_playlist_card_play);
            info = itemView.findViewById(R.id.img_playlist_card_prop);
            favorite = itemView.findViewById(R.id.img_playlist_card_favorite);
        }
    }
}
