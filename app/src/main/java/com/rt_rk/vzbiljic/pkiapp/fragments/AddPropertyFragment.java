package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.R;

/**
 * Created by Xeobo on 3/20/2017.
 */

public class AddPropertyFragment extends AbstractFragment implements View.OnClickListener{
    private View root;

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
        {
            Button button  = (Button) root.findViewById(R.id.search);

            button.setOnClickListener(this);
        }


        return root;

    }

    @Override
    public void onClick(View view) {
        changeToFragment(new UserListFragment());
    }

}
