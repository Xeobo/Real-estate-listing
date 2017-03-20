package com.rt_rk.vzbiljic.pkiapp.fragments;

/**
 * Created by vzbiljic on 20.3.17..
 */

public class SearchAgentFragment extends AbstractSearchUserFragment {
    @Override
    protected AbstractActivityFragment getFragmentForResults() {
        return new AgentActivityFragment();
    }

    @Override
    protected String getLabel() {
        return "Agent:";
    }

    @Override
    protected CharSequence getHeading() {
        return "Pretraži agenta";
    }
}
