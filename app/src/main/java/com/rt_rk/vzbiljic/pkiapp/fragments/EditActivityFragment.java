package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.bean.Activity;
import com.rt_rk.vzbiljic.pkiapp.bean.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by vzbiljic on 17.3.17..
 */

public class EditActivityFragment extends AbstractManageActivityFragment {
    private static final String TAG = "EditActivityFragment";
    private Activity activity;
    private Fragment fragment;


    public void setActivity(Activity activity){
        this.activity = activity;
    }

    public void setFragment(Fragment fragment){
        this.fragment = fragment;
    }

    @Override
    protected void updateDataSource(Calendar date, String user, String agent, String note) {
        if(null != activity){
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");


            activity.setAgent(agent);
            activity.setUser(user);
            activity.setDatum(format.format(date.getTime()));


            if(note.equals(Activity.ActivityType.OFFER.toString())){
                //TODO read from amount input fied;
                activity.setAmount(150);
            }
            activity.setType(Activity.ActivityType.fromString(note));

        }else{
            Log.w(TAG,"Editing activity not set!");
        }

        if(null != fragment) {
            changeToFragment(fragment);

        }else{
            Log.w(TAG,"Return Fragment not set!!");
        }
    }

    @Override
    protected void initLayout(View root) {
        ((TextView)getActivity().findViewById(R.id.mainName)).setText("Izmena");
        ((Button)root.findViewById(R.id.add_edit_activity_details)).setText("Izmeni");



        if(null != activity){
            ((AutoCompleteTextView)root.findViewById(R.id.add_edit_user)).setText(activity.getUser());
            ((AutoCompleteTextView)root.findViewById(R.id.add_edit_agent)).setText(activity.getAgent());
            ((TextView)root.findViewById(R.id.add_edit_date)).setText(activity.getDatum());

            ((Spinner)root.findViewById(R.id.add_edit_note)).setSelection(activity.getType().ordinal());
        }else{
            Log.e(TAG,"Editing activity not set!");
        }

    }
}
