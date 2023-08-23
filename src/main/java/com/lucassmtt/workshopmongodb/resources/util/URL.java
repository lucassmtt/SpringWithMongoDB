package com.lucassmtt.workshopmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeParam(String textEncoding){
        try{
            return URLDecoder.decode(textEncoding, "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            return "";
        }
    }
}
