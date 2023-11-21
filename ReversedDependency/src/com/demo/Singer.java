package com.demo;

public class Singer {
    private ISong iSong;

    public void singASong(ISong iSong) {
        System.out.println("The singer is sing " + iSong.getLyrics());
    }

    public static void main(String[] args) {
        Singer singer = new Singer();
        singer.singASong(new ChineseSong());
    }
}
