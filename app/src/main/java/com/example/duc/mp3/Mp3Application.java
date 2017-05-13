package com.example.duc.mp3;

import android.app.Application;

import com.example.duc.mp3.managers.DbContext;
import com.example.duc.mp3.managers.NetWorkManager;
import com.example.duc.mp3.utils.Exo;

import butterknife.ButterKnife;

/**
 * Created by DUC on 30/11/2016.
 */

public class Mp3Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkManager.init(this);
        DbContext.init(this);
        Exo.init(this);

    }
}
