package com.predex;

/**
 * Created by james on 15/5/28.
 * Copyright (c) 2015 james. All rights reserved.
 */
public class CheckDex {
    static {
        try {
            System.loadLibrary("predex2.3");
        }catch (Exception e){

        }
    }
    public static final String text="CheckDex";

    public native long getStartSize();
    public native long extendSize();
}
