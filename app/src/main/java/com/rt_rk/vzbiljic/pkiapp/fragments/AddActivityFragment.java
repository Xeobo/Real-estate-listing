package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.bean.Activity;
import com.rt_rk.vzbiljic.pkiapp.datasource.manager.ActivityDataSourceManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Xeobo on 3/18/2017.
 */

public class AddActivityFragment extends AbstractManageActivityFragment {
    private int currentPropertyID;


    @Override
    protected void initLayout(View root) {
        ((Button)root.findViewById(R.id.add_edit_activity_details)).setText("Dodaj");
    }

    @Override
    protected void updateDataSource(Calendar date, String user, String agent, Activity.ActivityType note, int amount) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");

        ActivityDataSourceManager.getInstance().getDataSource(currentPropertyID).add(
                new Activity(
                        format.format(date.getTime()),
                        user,
                        agent,
                        note,
                        amount
                ));
    }

    public void setCurrentPropertyID(int currentPropertyID) {
        this.currentPropertyID = currentPropertyID;
    }

    @Override
    protected CharSequence getHeading() {
        return "Dodavanje";
    }
}
