package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.bean.User;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;

/**
 * Created by vzbiljic on 20.3.17..
 */

public abstract class AbstractActivityFragment extends AbstractFragment {
    protected LayoutInflater inflater;
    protected User user;


    protected abstract boolean isAgent();

    @Override
    protected final View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;

        View root = inflater.inflate(R.layout.fragment_activity_list,container,false);
        ShownPropertyListFragment fragment = new ShownPropertyListFragment();

        fragment.setContext(getActivity());

        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_activity_list_fragment_frame, fragment).commit();

        root.findViewById(R.id.fragment_activity_list_agnecy).setVisibility(isAgent()?View.VISIBLE:View.INVISIBLE);
        root.findViewById(R.id.textView25).setVisibility(isAgent()?View.VISIBLE:View.INVISIBLE);

        ((TextView)root.findViewById(R.id.fragment_activity_list_userName)).setText(user.getUsername());
        ((TextView)root.findViewById(R.id.fragment_activity_list_telephone)).setText(user.getTelephone());

        if(isAgent())
            ((TextView)root.findViewById(R.id.fragment_activity_list_agnecy)).setText(user.getAgency());

        return root;
    }



    public void setUser(User user) {
        this.user = user;
    }
}
