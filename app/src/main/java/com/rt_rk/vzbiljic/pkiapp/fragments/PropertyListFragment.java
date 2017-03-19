package com.rt_rk.vzbiljic.pkiapp.fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.adapters.PropertyListAdapter;
import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;

/**
 * A simple {@link Fragment} subclass.
 */
public class PropertyListFragment extends ListViewFragment {

    @Override
    protected CharSequence getHeading() {
        return "Nekretnine";
    }


    public PropertyListFragment() {
        // Required empty public constructor
    }

    @Override
    protected ListAdapter getListAdapter() {
        PropertyListAdapter propertyListAdapter = new PropertyListAdapter(getActivity());
        return propertyListAdapter;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View mView = inflater.inflate(R.layout.fragment_details_dialog_activity,null);

        //date
        TextView dialogText = (TextView) mView.findViewById(R.id.dialog_date);

        builder.setView(mView);

    }
}
