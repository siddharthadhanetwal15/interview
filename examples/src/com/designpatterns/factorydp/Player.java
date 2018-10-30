package com.designpatterns.factorydp;

import java.io.InputStream;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class Player {
    public void play(String mediaFileName){
        if(mediaFileName == null || "".equals(mediaFileName)){
            throw new RuntimeException("invalid media file");
        }
        Decoder decoder = DecoderFactory.getMediaDecoder(mediaFileName);
        if(decoder != null){
            play(decoder.decodeFile(mediaFileName));
        }else {
            throw new RuntimeException("Media format not supported.");
        }
    }

    private void play(InputStream stream){
        System.out.println("Playing..$..$");
    }
}
