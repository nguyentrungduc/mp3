package com.example.duc.mp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenresFragment extends Fragment {

    @BindView(R.id.genres_Cv)
    RecyclerView genrescv;



    public GenresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_genres, container, false);
        setupUI();
        return view;
    }

    private void setupUI() {
//        GridLayoutManager manager = new
//                GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return (position % 3 == 0 ? 2 : 1);
//            }
//
//        });
//        GenresAdapter genresAdapter = new GenresAdapter();
//        genrescv.setAdapter(genresAdapter);
    }

}
