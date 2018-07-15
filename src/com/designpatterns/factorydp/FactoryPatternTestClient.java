package com.designpatterns.factorydp;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class FactoryPatternTestClient {
    public static void main(String[] args) {
        String mediaFile = "C://songs/song1.mp3";
        Player player = new Player();
        player.play(mediaFile);
        //play other file
        mediaFile = "C://videos/song2.mp4";
        player.play(mediaFile);
    }
}
