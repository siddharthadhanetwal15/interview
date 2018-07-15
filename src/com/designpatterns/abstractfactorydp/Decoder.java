package com.designpatterns.abstractfactorydp;

import java.io.InputStream;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public interface Decoder {
    InputStream decodeFile(String mediaFileName);
}
