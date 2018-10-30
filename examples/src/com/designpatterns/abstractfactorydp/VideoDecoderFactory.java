package com.designpatterns.abstractfactorydp;

/**
 * Created by dhanetwa on 6/18/2018.
 */
public class VideoDecoderFactory implements DecoderFactory {
    @Override
    public Decoder getDecoder(String type) {
        type = type.toUpperCase();
        if(type.equalsIgnoreCase("MP4")){
            return new MP4Decoder();
        }else if(type.equalsIgnoreCase("FLV")){
            return new FLVDecoder();
        }
        return null;
    }
}
