package com.rt_rk.vzbiljic.pkiapp.fragments;

/**
 * Created by vzbiljic on 20.3.17..
 */

public class AgentActivityFragment extends AbstractActivityFragment {
    @Override
    protected boolean isAgent() {
        return true;
    }

    @Override
    protected CharSequence getHeading() {
        return "Posećene nekretnine";
    }
}
