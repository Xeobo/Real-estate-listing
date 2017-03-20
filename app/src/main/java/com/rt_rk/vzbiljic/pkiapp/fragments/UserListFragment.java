package com.rt_rk.vzbiljic.pkiapp.fragments;


import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.adapters.UserDialogListView;
import com.rt_rk.vzbiljic.pkiapp.adapters.UserListAdapter;
import com.rt_rk.vzbiljic.pkiapp.bean.User;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;

/**
 * Created by Xeobo on 3/18/2017.
 */

public class UserListFragment extends ListViewFragment {

    @Override
    protected CharSequence getHeading() {
        return "Korisnici";
    }

    @Override
    protected ListAdapter getListAdapter() {
        return new UserListAdapter(getActivity());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int userID, long l) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final int finalUserID = userID;

        View mView = inflater.inflate(R.layout.fragment_user_list_dialog,null);

        ((TextView)mView.findViewById(R.id.dialog_agent_name)).setText(
                ((TextView) mView.findViewById(R.id.dialog_agent_name)).getText()
                        +" "+ UserDataSource.getInstance().get(userID).getUsername());

        ((TextView)mView.findViewById(R.id.dialog_telephone)).setText(
                ((TextView) mView.findViewById(R.id.dialog_telephone)).getText()
                        +" "+ UserDataSource.getInstance().get(userID).getTelephone());

        ((TextView)mView.findViewById(R.id.dialog_agency)).setText(
                ((TextView) mView.findViewById(R.id.dialog_agency)).getText()
                        +" "+ UserDataSource.getInstance().get(userID).getAgency());


        ListView lw = (ListView)mView.findViewById(R.id.details_list);

        builder.setView(mView);

        final AlertDialog dialog = builder.create();
        dialog.show();

        lw.setAdapter(new UserDialogListView( getActivity()));

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialog.dismiss();
                switch (i){
                    case 0://edit
                        EditUserFragment fragment = new EditUserFragment();
                        fragment.setUser(UserDataSource.getInstance().get(finalUserID));
                        fragment.setFragment(UserListFragment.this);
                        changeToFragment(fragment);
                        break;
                    case 1://delete
                        UserDataSource.getInstance().remove(finalUserID);
                        refreshFragment();
                        break;

                }

            }
        });
    }


}
