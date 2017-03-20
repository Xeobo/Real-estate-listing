package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.adapters.ShownPropertyListAdapter;

/**
 * Created by vzbiljic on 20.3.17..
 */

public class ShownPropertyListFragment extends AbstractInnerListViewFragment {
    private ShownPropertyListAdapter la;


    public void setContext(Context context){
        la = new ShownPropertyListAdapter(context);
    }

    @Override
    protected ListAdapter getListAdapter() {
        return la;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


}
