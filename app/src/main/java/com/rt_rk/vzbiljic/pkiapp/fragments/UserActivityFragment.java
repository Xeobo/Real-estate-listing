package com.rt_rk.vzbiljic.pkiapp.fragments;

/**
 * Created by vzbiljic on 20.3.17..
 */

public class UserActivityFragment extends AbstractActivityFragment {
    @Override
    protected boolean isAgent() {
        return false;
    }

    @Override
    protected CharSequence getHeading() {
        return "Obiđene nekretnine";
    }
}
