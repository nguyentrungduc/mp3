package com.example.duc.mp3;

import android.support.v4.app.Fragment;

/**
 * Created by DUC on 30/11/2016.
 */

public class FragmentEvent {
    private Fragment fragment;
    private boolean addtoBackStack;


    public FragmentEvent(Fragment fragment, boolean addtoBackStack) {
        this.fragment = fragment;
        this.addtoBackStack = addtoBackStack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public boolean isAddtoBackStack() {
        return addtoBackStack;
    }

    public void setAddtoBackStack(boolean addtoBackStack) {
        this.addtoBackStack = addtoBackStack;
    }
}
