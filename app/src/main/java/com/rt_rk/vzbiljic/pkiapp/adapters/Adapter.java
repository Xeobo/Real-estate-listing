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

/**
 * Created by vzbiljic on 26.1.17..
 */
public class Adapter extends ArrayAdapter<String> {

    private Context context;
    private LayoutInflater inflater;


    public Adapter(Context context){
        super(context, R.layout.model_list, PropertyDataSource.getInstance().getDescription());

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.model_list,null);
        }

        final ViewHolder viewHolder = new ViewHolder();

        viewHolder.nameTV = (TextView) convertView.findViewById(R.id.name);
        viewHolder.priceTV = (TextView) convertView.findViewById(R.id.price);
        viewHolder.img = (ImageView) convertView.findViewById(R.id.logo);

        viewHolder.nameTV.setText(PropertyDataSource.getInstance().get(position).getName());
        viewHolder.priceTV.setText(PropertyDataSource.getInstance().get(position).getPrice());
        viewHolder.img.setImageResource(PropertyDataSource.getInstance().get(position).getImage());

        return convertView;
    }


    public class ViewHolder{
        TextView nameTV;
        TextView priceTV;
        ImageView img;
    }
}
