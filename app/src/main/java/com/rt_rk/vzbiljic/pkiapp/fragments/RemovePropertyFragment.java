package com.rt_rk.vzbiljic.pkiapp.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.adapters.PropertyListAdapter;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;

/**
 * Created by vzbiljic on 20.3.17..
 */

public class RemovePropertyFragment extends ListViewFragment {
    @Override
    protected CharSequence getHeading() {
        return "Izdato i prodato";
    }


    @Override
    protected ListAdapter getListAdapter() {
        return new PropertyListAdapter(getActivity());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final int finalPosition = position;
        builder
                .setMessage("Da li zelite da obrisete ovu nekretninu?")
                .setCancelable(false)
                .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        PropertyDataSource.getInstance().remove(finalPosition);
                        refreshFragment();

                    }
                })
                .setNegativeButton("Ne", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog d = builder.create();

        d.show();

        //set button colors
        Button bq = d.getButton(DialogInterface.BUTTON_NEGATIVE);
        bq.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));

        bq = d.getButton(DialogInterface.BUTTON_POSITIVE);
        bq.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));

    }
}
