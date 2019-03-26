package com.blucode.mhmd.session6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class HeterogenousRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> itemList;
    private Context mContext;
    private final int VIEW1 = 0, VIEW2 = 1;


    public HeterogenousRecyclerAdapter(Context mContext, List<Object> itemList) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case VIEW1:

                break;
            case VIEW2:

                break;
            default:

                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW1:

                break;
            case VIEW2:

                break;
            default:

                break;
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (itemList.get(position) instanceof String) {
            return VIEW1;
        } else if (itemList.get(position) instanceof String) {
            return VIEW2;
        }
        return -1;
    }
}
