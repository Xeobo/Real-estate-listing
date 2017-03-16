package com.rt_rk.vzbiljic.pkiapp.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;

import java.util.Calendar;

/**
 * Created by Xeobo on 3/16/2017.
 */

public class AddActivityFragment extends Fragment  implements DatePickerDialog.OnDateSetListener{
    private int year,month,day;
    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.add_or_edit_activity_fragment, (FrameLayout) getActivity().findViewById(R.id.fragment_container), false);

        Button button = (Button)root.findViewById(R.id.add_edit_activity_details);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        TextView et = (TextView) root.findViewById(R.id.add_edit_date);

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog  = new DatePickerDialog(getActivity(),AddActivityFragment.this,year,month,day);

                dialog.show();
            }
        });

        AutoCompleteTextView add_edit_agent = (AutoCompleteTextView) root.findViewById(R.id.add_edit_agent);
        AutoCompleteTextView add_edit_user = (AutoCompleteTextView) root.findViewById(R.id.add_edit_user);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, UserDataSource.getInstance().getDescription());

        add_edit_agent.setThreshold(1);
        add_edit_user.setThreshold(1);

        add_edit_agent.setAdapter(adapter);
        add_edit_user.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        year = i;
        month = i1 + 1;
        day = i2;
        ((TextView)root.findViewById(R.id.add_edit_date)).setText(day + "/" + month + "/" + year);
    }
}
