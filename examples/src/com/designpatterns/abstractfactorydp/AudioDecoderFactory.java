package com.designpatterns.abstractfactorydp;

/**
 * Created by dhanetwa on 6/18/2018.
 */
public class AudioDecoderFactory implements DecoderFactory {
    @Override
    public Decoder getDecoder(String type) {
        type = type.toUpperCase();
        if(type.equalsIgnoreCase("MP3")){
            return new MP3Decoder();
        }else if(type.equalsIgnoreCase("ACC")){
            return new ACCDecoder();
        }
        return null;
    }
}
