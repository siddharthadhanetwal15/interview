package com.designpatterns.abstractfactorydp;

import java.io.InputStream;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class MP4Decoder implements Decoder {
    @Override
    public InputStream decodeFile(String mediaFileName) {
        System.out.println("MP4Decoder: decoding file " + mediaFileName);
        return null;
    }
}
