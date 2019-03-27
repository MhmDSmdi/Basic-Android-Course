package com.blucode.mhmd.session6;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blucode.mhmd.session6.data.TextMessage;
import com.blucode.mhmd.session6.data.VoiceMessage;

import java.text.SimpleDateFormat;
import java.util.List;

public class ShareContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> itemList;
    private Context mContext;
    private final int TEXT_MESSAGE = 0, VOICE_MESSAGE = 1;

    public ShareContentAdapter(Context mContext, List<Object> itemList) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TEXT_MESSAGE:
                View textMessageView = inflater.inflate(R.layout.card_text_message, parent, false);
                viewHolder = new TextMessageViewHolder(textMessageView);
                break;
            case VOICE_MESSAGE:
                View voiceMessageView = inflater.inflate(R.layout.card_voice_message, parent, false);
                viewHolder = new VoiceMessageViewHolder(voiceMessageView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TEXT_MESSAGE:
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, h:mm a");
                final TextMessage textMessage = (TextMessage) itemList.get(position);
                TextMessageViewHolder textMessageViewHolder = (TextMessageViewHolder)(holder);
                textMessageViewHolder.getTime().setText(dateFormat.format(textMessage.getTime()));
                textMessageViewHolder.getBodyMessage().setText(textMessage.getText());
                break;
            case VOICE_MESSAGE:
                dateFormat = new SimpleDateFormat("EEE, MMM d, h:mm a");
                final VoiceMessage voiceMessage = (VoiceMessage) itemList.get(position);
                VoiceMessageViewHolder voiceMessageViewHolder = (VoiceMessageViewHolder) (holder);
                voiceMessageViewHolder.getTime().setText(dateFormat.format(voiceMessage.getTime()));
                voiceMessageViewHolder.getBody().setText(voiceMessage.getBodyMessage());
                voiceMessageViewHolder.getDuration().setText(voiceMessage.getDurationFormative());
                voiceMessageViewHolder.getPlay().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        try {
                            mediaPlayer.setDataSource(voiceMessage.getPath());
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                            Toast.makeText(mContext, "Playing Audio", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (itemList.get(position) instanceof TextMessage) {
            return TEXT_MESSAGE;
        } else if (itemList.get(position) instanceof VoiceMessage) {
            return VOICE_MESSAGE;
        }
        return -1;
    }
}
