package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;

/**
 * Created by Xeobo on 3/19/2017.
 */

public class EditUserFragment extends AbstractFragment {
    @Override
    protected CharSequence getHeading() {
        return "Izmeni";
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.fragment_blank, (FrameLayout) getActivity().findViewById(R.id.fragment_container), false);
        return view;
    }
}
