package com.blucode.mhmd.section3.data;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String name;
    private int img;
    private List<Song> songs;
    private int time;
    private boolean isFavorite;

    public PlayList(String name, List<Song> songs, int time, int img) {
        this.name = name;
        this.songs = songs;
        this.time = time;
        this.img = img;
    }

    public PlayList(String name) {
        this.name = name;
        songs = new ArrayList<>();
        time = 0;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSizeOfPlayList() {
        return songs.size();
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
