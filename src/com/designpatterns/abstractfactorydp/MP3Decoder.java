package com.designpatterns.abstractfactorydp;

import java.io.InputStream;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class MP3Decoder implements Decoder {
    @Override
    public InputStream decodeFile(String mediaFileName) {
        //decode your file here and return the decoded stream
        System.out.println("MP3Decoder: decoding file " + mediaFileName);
        return null;
    }
}
