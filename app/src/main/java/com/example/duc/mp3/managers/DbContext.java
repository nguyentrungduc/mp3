package com.example.duc.mp3.managers;

import android.content.Context;

import com.example.duc.mp3.models.GenresItem;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by DUC on 30/11/2016.
 */

public class DbContext {
    private Realm realm;

    public DbContext(Context context){
        Realm.init(context);
        realm = Realm.getDefaultInstance();

    }

    private static DbContext instance;

    public static DbContext getInstance(){
        return instance;
    }

    public static void init(Context context){
        if(instance == null) {
            instance = new DbContext(context);
        }
    }

    public void add(GenresItem genresItem){
        realm.beginTransaction();
        realm.copyToRealm(genresItem);
        realm.commitTransaction();
    }

    public long getSize() {
        return realm.where(GenresItem.class).count();
    }

    public List<GenresItem> findAll(){
        Realm realm = Realm.getDefaultInstance();

        //3 Query - lazy load
        RealmResults<GenresItem> genresItems =
                realm.where(GenresItem.class)
                        .findAll();
        return genresItems;
    }
}
