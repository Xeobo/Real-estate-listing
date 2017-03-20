package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;

/**
 * Created by vzbiljic on 20.3.17..
 */

public class AssignPropertyToAgent extends AbstractFragment {

    @Override
    protected CharSequence getHeading() {
        return "Dodela agentu";
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_assign_property_to_agent,container,false);
        AutoCompleteTextView property = (AutoCompleteTextView)root.findViewById(R.id.fragment_assign_property_to_agent_property_list);
        AutoCompleteTextView agent = (AutoCompleteTextView)root.findViewById(R.id.fragment_assign_property_to_agent_user_list);
        Button button = (Button) root.findViewById(R.id.fragment_assign_property_to_agent_user_action);

        property.setThreshold(1);
        property.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, PropertyDataSource.getInstance().getDescription()));

        agent.setThreshold(1);
        agent.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, UserDataSource.getInstance().getDescription()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AutoCompleteTextView property = (AutoCompleteTextView)root.findViewById(R.id.fragment_assign_property_to_agent_property_list);
                AutoCompleteTextView agent = (AutoCompleteTextView)root.findViewById(R.id.fragment_assign_property_to_agent_user_list);

                if(!UserDataSource.getInstance().checkIfUserExists(agent.getText().toString())){
                    Toast.makeText(getActivity(),"Nepoznat agent!",Toast.LENGTH_SHORT).show();
                }else if(!PropertyDataSource.getInstance().checkIfExists(property.getText().toString())){
                    Toast.makeText(getActivity(),"Nepoznata nekretnina!",Toast.LENGTH_SHORT).show();
                }else{
                    changeToFragment(new PropertyListFragment());
                }



            }
        });






        return root;
    }
}
