package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.bean.Activity;

/**
 * Created by vzbiljic on 20.3.17..
 */

public abstract class AbstractManageUserFragment extends AbstractFragment {
    protected Fragment fragment;
    protected LayoutInflater inflater;

    //initialize Layout details
    //derived classes cannot  override default behaviour of Fragment
    //all control is done trough  ! updateDataSource !
    protected abstract void initLayout(View root);

    //update data source when new data is entered
    protected abstract void updateDataSource(String user, String telefon, String agencija);

    @Override
    protected final View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;

        final View root = inflater.inflate(R.layout.fragment_manage_user,container,false);

        initLayout(root);

        Button button = (Button) root.findViewById(R.id.fragment_manage_user_manage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView user = (TextView) root.findViewById(R.id.fragment_manage_user_agent);
                EditText telephone = (EditText) root.findViewById(R.id.fragment_manage_user_telephone);
                EditText agency = (EditText) root.findViewById(R.id.fragment_manage_user_agency);

                updateDataSource(user.getText().toString(), telephone.getText().toString(), agency.getText().toString());

                changeToFragment(fragment);
            }
        });

        return root;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
