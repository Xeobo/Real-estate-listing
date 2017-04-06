package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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


public class SearchFragment extends AbstractFragment {
    private View root;

    public SearchFragment() {
        // Required empty public constructor
    }

    private int readIntegerField(View root,int id ){
        EditText toPrice = (EditText) root.findViewById(id);
        String str = toPrice.getText().toString();
        try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            Log.e("SearchFragment","Wrong number format");
            return -1;
        }
    }
    @Override
    protected CharSequence getHeading() {
        return "Pretraga";
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_search, container, false);
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

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragment = new PropertyListFragment();

                    int from = readIntegerField(root,R.id.fromPrice);

                    int to = readIntegerField(root,R.id.toPrice);

                    if(from > 0 && to>0 && from > to){
                        Toast.makeText(getActivity(),"Lose unet opseg cena",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    from = readIntegerField(root,R.id.fromPrice);

                    to = readIntegerField(root,R.id.toPrice);

                    if(from > 0 && to>0 && from > to){
                        Toast.makeText(getActivity(),"Lose unet opseg cena",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    changeToFragment(fragment);
                }
            });
        }

        //price search check
        {
            EditText fromPrice = (EditText) root.findViewById(R.id.fromPrice);

            fromPrice.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){

                    int from = readIntegerField(root,R.id.fromPrice);

                    int to = readIntegerField(root,R.id.toPrice);

                    if(from > 0 && to>0 && from > to){
                        Toast.makeText(getActivity(),"Lose unet opseg cena",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

            EditText toPrice = (EditText) root.findViewById(R.id.toPrice);

            toPrice.setOnFocusChangeListener(fromPrice.getOnFocusChangeListener());
        }

        //date search check
        {
            EditText inputDateFrom = (EditText) root.findViewById(R.id.inputDateFrom);

            inputDateFrom.setOnFocusChangeListener(new View.OnFocusChangeListener(){
                @Override
                public void onFocusChange(View view, boolean b) {
                    if(!b){

                        int from = readIntegerField(root,R.id.inputDateFrom);

                        int to = readIntegerField(root,R.id.inputDateTo);

                        if(from > 0 && to>0 && from > to){
                            Toast.makeText(getActivity(),"Lose unet opseg datuma",Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });

            EditText inputDateTo = (EditText) root.findViewById(R.id.inputDateTo);
            inputDateTo.setOnFocusChangeListener(inputDateFrom.getOnFocusChangeListener());
        }
        return root;
    }

}
