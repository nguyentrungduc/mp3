package com.example.duc.mp3.managers;

import android.content.Context;

import com.example.duc.mp3.models.GenresItem;
import com.example.duc.mp3.models.TopSongItem;

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

    public void addTopSong(TopSongItem topSongItem){
        realm.beginTransaction();
        realm.copyToRealm(topSongItem);
        realm.commitTransaction();
    }

    public void changeFavorite(GenresItem genresItem){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        genresItem.setFavorite(true);
        realm.commitTransaction();

    }

    public void changeNoFavorite(GenresItem genresItem){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        genresItem.setFavorite(false);
        realm.commitTransaction();

    }

    public long getSize() {
        return realm.where(GenresItem.class).count();
    }

    public List<GenresItem> findAll(){
        Realm realm = Realm.getDefaultInstance();

        RealmResults<GenresItem> genresItems =
                realm.where(GenresItem.class)
                        .findAll();
        return genresItems;
    }

    public void deleteAllObject(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    public List<GenresItem> findAllFavorite(){
        Realm realm = Realm.getDefaultInstance();

        //3 Query - lazy load
        RealmResults<GenresItem> genresItems =
                realm.where(GenresItem.class)
                        .equalTo("isFavorite",true).findAll();
        return genresItems;
    }

    public List<TopSongItem> findAllTopSong(){
        Realm realm = Realm.getDefaultInstance();

        RealmResults<TopSongItem> topSongItems =
                realm.where(TopSongItem.class)
                        .findAll();
        return topSongItems;
    }


    public long getSizeTopSong(){
        return realm.where(TopSongItem.class).count();
    }

    public boolean check(String id){
        Realm realm = Realm.getDefaultInstance();

        RealmResults<TopSongItem> topSongItems =
                realm.where(TopSongItem.class)
                        .findAll();
        for(TopSongItem topSongItem : topSongItems){
            if(topSongItem.getId().equals(id) == true){
                return false;
            }
        }
        return true;

    }

    public List<TopSongItem> findTopSongByID(String id){
        Realm realm = Realm.getDefaultInstance();


        RealmResults<TopSongItem> topSongItems =
                realm.where(TopSongItem.class)
                        .equalTo("id", id).findAll();
        return topSongItems;
    }


}
