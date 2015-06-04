package com.predex;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import dalvik.system.DexClassLoader;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DexClassLoader classLoader = new DexClassLoader("/sdcard/xiamiv5.apk", getApplicationInfo().dataDir, null,this.getClass().getClassLoader());
                        CheckDex.checkPreDexInfo(new String("/sdcard/xiami_classes.dex"),new String("/sdcard/sdcard@xiami_classes.dex"),classLoader);
//                        CheckDex.checkPreDexInfo(new String("/sdcard/classes2.dex"),new String("/sdcard/sdcard@classes2.dex"),classLoader);

//                        DexClassLoader classLoader = new DexClassLoader("/sdcard/TTPod-debug.apk", getApplicationInfo().dataDir, null,this.getClass().getClassLoader());
//                        CheckDex.checkPreDexInfo(new String("/sdcard/classes.dex"),new String("/sdcard/sdcard@classes.dex"),classLoader);
//                        CheckDex.checkPreDexInfo(new String("/sdcard/classes2.dex"),new String("/sdcard/sdcard@classes2.dex"),classLoader);
                    }
                }).start();

//                CheckDex.checkPreDexInfo(new String("/sdcard/xiamiv5.apk"));
//                CheckDex.checkPreDexInfoJNI("/sdcard/classes.dex");
            }
        });
    }
}
