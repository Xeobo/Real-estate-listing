package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.widget.ListView;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;

/**
 * Created by vzbiljic on 20.3.17..
 */

public abstract class AbstractInnerListViewFragment extends ListViewFragment {

    @Override
    protected CharSequence getHeading() {
        return  ((TextView)getActivity().findViewById(R.id.mainName)).getText();
    }

}
