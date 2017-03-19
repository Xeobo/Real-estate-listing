package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.adapters.PropertyListAdapter;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;

/**
 * Created by Xeobo on 3/18/2017.
 */

public abstract class ListViewFragment extends AbstractFragment implements AdapterView.OnItemClickListener{
    protected LayoutInflater inflater;


    @Override
    protected final View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.content_start, container, false);

        this.inflater = inflater;

        ListView listView;

        listView = (ListView) rootView.findViewById(R.id.listView);
        ListAdapter propertyListAdapter = getListAdapter();
        listView.setAdapter(propertyListAdapter);

        listView.setOnItemClickListener(this);

        return rootView;
    }


    protected abstract ListAdapter getListAdapter();
}
