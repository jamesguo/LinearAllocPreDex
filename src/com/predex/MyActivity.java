package com.predex;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import dalvik.system.DexClassLoader;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
static {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        fragment = new Fragment();
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String text =CheckDex.text;
                        CheckDex dex = new CheckDex();
                        Log.e("Tag", "Start size " + dex.getStartSize()) ;
                        Log.e("Tag", "Extend size " + dex.extendSize()) ;
                        DexClassLoader classLoader = new DexClassLoader("/sdcard/TTPod-debug.apk", getApplicationInfo().dataDir, null,this.getClass().getClassLoader());
                        Log.e("Tag", "Start size " + dex.getStartSize()) ;
                    }
                }).start();

            }
        });
    }
}
