package com.designpatterns.abstractfactorydp;

import java.io.InputStream;

/**
 * Created by dhanetwa on 6/18/2018.
 */
public class FLVDecoder implements Decoder {
    @Override
    public InputStream decodeFile(String mediaFileName) {
        System.out.println("FLV Decoder, decoding file : " + mediaFileName);
        return null;
    }
}
