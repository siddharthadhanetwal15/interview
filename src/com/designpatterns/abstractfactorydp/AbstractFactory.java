package com.designpatterns.abstractfactorydp;


/**
 * Created by dhanetwa on 6/18/2018.
 */
public class AbstractFactory {
    public static DecoderFactory getMediaDecoder(String type){
        if("audio".equalsIgnoreCase(type)){
            return new AudioDecoderFactory();
        }else if("video".equalsIgnoreCase(type)){
            return new VideoDecoderFactory();
        }
        throw new RuntimeException("type not supported: "+type);
    }
}
