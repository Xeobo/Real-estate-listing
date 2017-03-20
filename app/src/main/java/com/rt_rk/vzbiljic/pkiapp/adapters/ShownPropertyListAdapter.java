package com.rt_rk.vzbiljic.pkiapp.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.bean.User;
import com.rt_rk.vzbiljic.pkiapp.datasource.ActivityDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.manager.ActivityDataSourceManager;

/**
 * Created by vzbiljic on 20.3.17..
 */

public class ShownPropertyListAdapter extends ArrayAdapter<String>{
    private Context context;
    private LayoutInflater inflater;

    public ShownPropertyListAdapter(@NonNull Context context) {
        super(context, R.layout.property_model_list, PropertyDataSource.getInstance().getDescription());

        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.property_model_list,null);
        }

        final PropertyListAdapter.ViewHolder viewHolder = new PropertyListAdapter.ViewHolder();

        viewHolder.nameTV = (TextView) convertView.findViewById(R.id.name);
        viewHolder.priceTV = (TextView) convertView.findViewById(R.id.price);
        viewHolder.img = (ImageView) convertView.findViewById(R.id.logo);

        viewHolder.nameTV.setText("Obilazak: 20.12.2016. 14:27");
        viewHolder.priceTV.setText(PropertyDataSource.getInstance().get(position).getPrice());
        viewHolder.img.setImageResource(PropertyDataSource.getInstance().get(position).getImage());

        return convertView;

    }

}
