package com.rt_rk.vzbiljic.pkiapp.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.bean.Activity;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Xeobo on 3/16/2017.
 */

public abstract class AbstractManageActivityFragment extends AbstractFragment  implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener{
    private int year,month,day;
    private View root;
    private String note;


    //initialize Layout details
    //derived classes cannot  override default behaviour of Fragment
    //all control is done trough  ! updateDataSource !
    protected abstract void initLayout(View root);


    //update data source when new data is entered
    protected abstract void updateDataSource(Calendar date, String user, String agent, String note);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.add_or_edit_activity_fragment, (FrameLayout) getActivity().findViewById(R.id.fragment_container), false);

        initLayout(root);

        Button button = (Button)root.findViewById(R.id.add_edit_activity_details);

        final Spinner spinner;





        spinner = ((Spinner)(root.findViewById(R.id.add_edit_note)));
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, Activity.ActivityType.stringValues());
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Delegate listener to derived classes
                Calendar date = new GregorianCalendar();
                date.set(Calendar.YEAR,year);
                date.set(Calendar.MONTH,month);
                date.set(Calendar.DAY_OF_MONTH,day);

                String user = ((AutoCompleteTextView)(root.findViewById(R.id.add_edit_user))).getText().toString();
                String agent = ((AutoCompleteTextView)(root.findViewById(R.id.add_edit_agent))).getText().toString();


                updateDataSource(date,user,agent,note);
            }
        });

        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        TextView et = (TextView) root.findViewById(R.id.add_edit_date);

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog  = new DatePickerDialog(getActivity(),AbstractManageActivityFragment.this,year,month,day);

                dialog.show();
            }
        });

        AutoCompleteTextView add_edit_agent = (AutoCompleteTextView) root.findViewById(R.id.add_edit_agent);
        AutoCompleteTextView add_edit_user = (AutoCompleteTextView) root.findViewById(R.id.add_edit_user);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, UserDataSource.getInstance().getDescription());

        add_edit_agent.setThreshold(1);
        add_edit_user.setThreshold(1);

        add_edit_agent.setAdapter(arrayAdapter);
        add_edit_user.setAdapter(arrayAdapter);





        return root;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        year = i;
        month = i1;
        day = i2;
        ((TextView)root.findViewById(R.id.add_edit_date)).setText(day + "." + (month+1) + "." + year);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        note = Activity.ActivityType.stringValues()[position];

        if(Activity.ActivityType.OFFER == Activity.ActivityType.fromString(note)){
            //TODO display amount input fied;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
