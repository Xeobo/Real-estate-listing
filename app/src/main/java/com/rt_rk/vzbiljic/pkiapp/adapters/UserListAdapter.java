package com.rt_rk.vzbiljic.pkiapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;

/**
 * Created by Xeobo on 3/18/2017.
 */

public class UserListAdapter extends ArrayAdapter<String> {
    private Context context;
    private LayoutInflater inflater;

    public UserListAdapter(Context context){
        super(context, R.layout.user_model_list, UserDataSource.getInstance().getDescription());

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.user_model_list,null);
        }

        TextView agentTV = (TextView) convertView.findViewById(R.id.user_list_agent);
        TextView telephoneTV = (TextView) convertView.findViewById(R.id.user_list_telephone);
        TextView agencyTV = (TextView) convertView.findViewById(R.id.user_list_agency);

        agentTV.setText(UserDataSource.getInstance().get(position).getUsername());
        telephoneTV.setText(UserDataSource.getInstance().get(position).getTelephone());
        agencyTV.setText(UserDataSource.getInstance().get(position).getAgency());

        return convertView;
    }
}
