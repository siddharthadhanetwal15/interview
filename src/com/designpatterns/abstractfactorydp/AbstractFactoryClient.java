package com.designpatterns.abstractfactorydp;

/**
 * Created by dhanetwa on 6/18/2018.
 */
public class AbstractFactoryClient {
    public static void main(String[] args) {
        // get Audio factory to produce audio decoders.
        DecoderFactory decoderFactory = AbstractFactory.getMediaDecoder("audio");
        Decoder decoder = decoderFactory.getDecoder("MP3");
        decoder.decodeFile("song.mp3");
        // get Video factory to produce video decoders
        decoderFactory = AbstractFactory.getMediaDecoder("video");
        decoder = decoderFactory.getDecoder("FLV");
        decoder.decodeFile("video.flv");
    }
}
