package com.example.duc.mp3.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 01/12/2016.
 */

public class PlayListItem {
    private String nameGenre;

    public PlayListItem(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    public static List<PlayListItem> list = new ArrayList<PlayListItem>(
    );
}
