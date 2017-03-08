package com.rt_rk.vzbiljic.pkiapp.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.Adapter;
import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.UserStartActivity;
import com.rt_rk.vzbiljic.pkiapp.utils.PropertyDataSource;

/**
 * A simple {@link Fragment} subclass.
 */
public class PropertyListFragment extends Fragment {

    public PropertyListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("PropertyListFragment","onAttach");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.content_start, (FrameLayout)getActivity().findViewById(R.id.fragment_container), false);

        ListView listView;

        listView = (ListView) rootView.findViewById(R.id.listView);
        Adapter adapter = new Adapter(getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getActivity(),
                        PropertyDataSource.getInstance().get(position).getName(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        return rootView;

    }

}
