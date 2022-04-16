package com.designpatterns.factorydp;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class DecoderFactory {
    public static Decoder getMediaDecoder(String mediaFileName) {
        mediaFileName = mediaFileName.toUpperCase();
        if (mediaFileName.endsWith(".MP3")) {
            return new MP3Decoder();
        } else if (mediaFileName.endsWith(".MP4")) {
            return new MP4Decoder();
        }
        return null;
    }
}
