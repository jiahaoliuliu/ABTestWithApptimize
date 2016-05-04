package com.jiahaoliuliu.abtestwithapptimize;

import android.app.Application;
import com.apptimize.Apptimize;

/**
 * Created by Jiahao on 5/4/16.
 */
public class MainApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();

        Apptimize.setup(this, APIKeys.APPTIMZIE_API_KEY);
    }
}
