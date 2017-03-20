package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vzbiljic on 20.3.17..
 */

public abstract class AbstractSearchUserFragment extends AbstractFragment implements DatePickerDialog.OnDateSetListener, View.OnClickListener{
    private View root;
    private TextView currentClicked;

    protected abstract AbstractActivityFragment getFragmentForResults();

    protected abstract String getLabel();

    @Override
    protected final View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_search_user,container,false);

        TextView label = (TextView)root.findViewById(R.id.fragment_search_user_agent_user_label);

        label.setText(getLabel());

        AutoCompleteTextView searchField = (AutoCompleteTextView) root.findViewById(R.id.fragment_search_user_agent);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, UserDataSource.getInstance().getDescription());

        searchField.setAdapter(arrayAdapter);
        searchField.setThreshold(1);

        TextView from = (TextView)root.findViewById(R.id.fragment_search_user_date_from);
        from.setOnClickListener(this);

        TextView to = (TextView)root.findViewById(R.id.fragment_search_user_date_to);
        to.setOnClickListener(this);

        Button search = (Button)root.findViewById(R.id.fragment_search_user_date_action);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView from = (TextView)root.findViewById(R.id.fragment_search_user_date_from);
                TextView to = (TextView)root.findViewById(R.id.fragment_search_user_date_to);
                AutoCompleteTextView user = (AutoCompleteTextView)root.findViewById(R.id.fragment_search_user_agent);
                SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy.");

                try {
                    Date fromDate = sdf.parse(from.getText().toString());
                    Date toDate = sdf.parse(to.getText().toString());

                    Log.i("Fragment", "from: " + fromDate + ", to: " + toDate);

                    if(fromDate.after(toDate)){
                        Toast.makeText(getActivity(),"Loše odabrani datumi!",Toast.LENGTH_SHORT).show();
                    }else if(!UserDataSource.getInstance().checkIfUserExists(user.getText().toString())){
                        Toast.makeText(getActivity(),"Nepoznat korisnik!",Toast.LENGTH_SHORT).show();
                    }else{
                        AbstractActivityFragment fragment = getFragmentForResults();
                        fragment.setUser(UserDataSource.getInstance().get(0));
                        changeToFragment(fragment);
                    }


                } catch (ParseException e) {
                    //should not happen!
                }




            }
        });




        return root;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        currentClicked.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year + ".");

    }

    @Override
    public void onClick(View v) {
        int year,month,day;
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        currentClicked = (TextView)v;

        DatePickerDialog dialog  = new DatePickerDialog(getActivity(), R.style.DialogTheme,AbstractSearchUserFragment.this,year,month,day);
        dialog.show();
    }

}
