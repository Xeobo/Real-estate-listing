package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.AttrRes;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Xeobo on 3/20/2017.
 */

public class AddPropertyFragment extends AbstractFragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener{
    private View root;
    private TextView currentClicked;

    private void showWarning(String price){
        Toast.makeText(getContext(),"Morate uneti polje: " + price, Toast.LENGTH_SHORT).show();
    }

    private boolean isEmptyOrNull(@IdRes int id, String name){
        String string = ((TextView)root.findViewById(id)).getText().toString();

        Log.i("TAG", "string: " + string);
        if(null == string || "".equals(string) || " ".equals(string)){
            showWarning(name);
            return true;
        }
        return false;
    }

    @Override
    protected CharSequence getHeading() {
        return "Dodavanje";
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_add_property, container, false);
        {
            Spinner staticSpinner = (Spinner) root.findViewById(R.id.structure_spinner);

            // Create an ArrayAdapter using the string array and a default spinner
            ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                    .createFromResource(getActivity(), R.array.structure_array,
                            android.R.layout.simple_spinner_item);

            // Specify the layout to use when the list of choices appears
            staticAdapter
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Apply the adapter to the spinner
            staticSpinner.setAdapter(staticAdapter);

        }
        {
            Spinner staticSpinner = (Spinner) root.findViewById(R.id.statusSwitch);

            // Create an ArrayAdapter using the string array and a default spinner
            ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                    .createFromResource(getActivity(), R.array.status_array,
                            android.R.layout.simple_spinner_item);

            // Specify the layout to use when the list of choices appears
            staticAdapter
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Apply the adapter to the spinner
            staticSpinner.setAdapter(staticAdapter);
        }
        {
            Spinner staticSpinner = (Spinner) root.findViewById(R.id.type_spinner);

            // Create an ArrayAdapter using the string array and a default spinner
            ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                    .createFromResource(getActivity(), R.array.type_array,
                            android.R.layout.simple_spinner_item);

            // Specify the layout to use when the list of choices appears
            staticAdapter
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Apply the adapter to the spinner
            staticSpinner.setAdapter(staticAdapter);
        }
        //date
        {
            TextView tv = (TextView) root.findViewById(R.id.inputDateFrom);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            tv.setText(sdf.format(Calendar.getInstance().getTime()));

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int year,month,day;
                    year = Calendar.getInstance().get(Calendar.YEAR);
                    month = Calendar.getInstance().get(Calendar.MONTH);
                    day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

                    currentClicked = (TextView)v;

                    DatePickerDialog dialog  = new DatePickerDialog(getActivity(), R.style.DialogTheme,AddPropertyFragment.this,year,month,day);
                    dialog.show();
                }
            });
        }

        {
            Button button  = (Button) root.findViewById(R.id.search);

            button.setOnClickListener(this);
        }


        return root;

    }

    @Override
    public void onClick(View view) {
        if(isEmptyOrNull(R.id.fromPrice, "cena") ||
                isEmptyOrNull(R.id.fromSurface, "povrsina") ||
                isEmptyOrNull(R.id.placeEdit, "mesto") ||
                isEmptyOrNull(R.id.communeEdit, "opstina") ||
                isEmptyOrNull(R.id.street, "ulica") ||
                isEmptyOrNull(R.id.streetNumberEdit, "number")
                ){
            return;
        }
        changeToFragment(new UserListFragment());
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        currentClicked.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year + ".");
    }
}
