package com.predex;

import dalvik.system.DexClassLoader;

/**
 * Created by james on 15/5/28.
 * Copyright (c) 2015 james. All rights reserved.
 */
public class CheckDex {
    static{
        System.loadLibrary("predex");
    }
    public static native void checkPreDexInfo(String filepath,String outputName,Object calssLoader);
    public static native void checkPreDexInfoJNI(String filepath);
}
