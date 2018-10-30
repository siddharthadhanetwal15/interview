package com.designpatterns.abstractfactorydp;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public interface DecoderFactory {
    Decoder getDecoder(String type);
}
