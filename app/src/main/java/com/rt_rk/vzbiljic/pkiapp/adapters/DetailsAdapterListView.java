package com.rt_rk.vzbiljic.pkiapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.utils.PropertyDataSource;

/**
 * Created by vzbiljic on 13.3.17..
 */

public class DetailsAdapterListView extends ArrayAdapter<String> {
    private Context context;
    private LayoutInflater inflater;

    public DetailsAdapterListView(Context context){
        super(context, R.layout.fragment_details_dialog_activity_details, ListViewOption.options());

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.fragment_details_dialog_activity_details,null);
        }

        final DetailsAdapterListView.ViewHolder viewHolder = new DetailsAdapterListView.ViewHolder();

        viewHolder.detailTV = (TextView) convertView.findViewById(R.id.detail_text);

        viewHolder.detailTV.setText(ListViewOption.fromInt(position).toString());

        return convertView;
    }


    public class ViewHolder{
        TextView detailTV;
    }

    public enum  ListViewOption{

        EDIT,
        ACCEPT,
        DELETE,
        CLOSE;

        private static String[] options = {
                "izmeni",
                "prihvati",
                "obrisi",
                "zatvori"
        };
        public static String[] options(){
            return options;
        }


        public static ListViewOption fromString(String string) {
            switch (string){
                case "zatvori": return CLOSE;
                case "izmeni": return EDIT;
                case "prihvati": return ACCEPT;
                case "obrisi": return DELETE;
                default: return null;
            }
        }
        public static ListViewOption fromInt(int index) {
            return ListViewOption.values()[index];
        }

        @Override
        public String toString() {
            switch (this){
                case CLOSE: return "zatvori";
                case EDIT: return "izmeni";
                case ACCEPT: return "prihvati";
                case DELETE: return "obrisi";
                default: return "other option";
            }
        }

    }
}
