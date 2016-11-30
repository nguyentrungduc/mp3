package com.example.duc.mp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.duc.mp3.R;
import com.example.duc.mp3.managers.DbContext;
import com.example.duc.mp3.models.GenresItem;
import com.example.duc.mp3.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailGenreFragment extends Fragment {

    @BindView(R.id.genre_Iv)
    ImageView genreiv;


    public DetailGenreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_genre, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        List<GenresItem> genresItems = DbContext.getInstance().findAll();
        int index = Preferences.getInstance().getIndexTouch();
        genreiv.setImageResource(genresItems.get(index).getImageId());

    }

}
