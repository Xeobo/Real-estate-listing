package com.rt_rk.vzbiljic.pkiapp.fragments;

/**
 * Created by vzbiljic on 20.3.17..
 */

public class SearchUserFragment extends AbstractSearchUserFragment {
    @Override
    protected AbstractActivityFragment getFragmentForResults() {
        return new UserActivityFragment();
    }

    @Override
    protected String getLabel() {
        return "Korisnik:";
    }

    @Override
    protected CharSequence getHeading() {
        return "Pretraži korisnike";
    }
}
