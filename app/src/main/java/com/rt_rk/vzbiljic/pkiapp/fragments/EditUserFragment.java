package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.bean.User;

/**
 * Created by Xeobo on 3/19/2017.
 */

public class EditUserFragment extends AbstractManageUserFragment {
    private User user;

    @Override
    protected CharSequence getHeading() {
        return "Izmeni";
    }


    @Override
    protected void initLayout(View root) {
        TextView tv = (TextView) root.findViewById(R.id.fragment_manage_user_agent);
        tv.setText(user.getUsername());

        tv = (TextView) root.findViewById(R.id.fragment_manage_user_telephone);
        tv.setText(user.getTelephone());

        tv = (TextView) root.findViewById(R.id.fragment_manage_user_agency);
        tv.setText(user.getAgency());

        Button button = (Button)root.findViewById(R.id.fragment_manage_user_manage);
        button.setText("Izmeni");

    }

    @Override
    protected void updateDataSource(String userName, String telefon, String agencija) {
        user.setTelephone(telefon);
        user.setAgency(agencija);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
