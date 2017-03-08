package com.rt_rk.vzbiljic.pkiapp.utils;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.bean.Property;

import java.util.ArrayList;

/**
 * Created by Xeobo on 2/4/2017.
 */

public class PropertyDataSource {

    private ArrayList<Property> list = new ArrayList<>();

    private static PropertyDataSource instance= null;

    private static int[] imgs = {R.drawable.mm, R.drawable.moler, R.drawable.omlad, R.drawable.kraljam, R.drawable.kraljicem, R.drawable.vojvodes};
    private static String[] names = {"Milutina Milankovica 19B", "Kralja Aleksandra 20A", "Nedeljka Cabrinovica 21","Rasinska 32", "Bratislave Petrovic BB", "Bulevar vojvode Misica"};
    private static String[] price = {"200$", "300$", "250$", "300$", "230$", "320$"};

    private PropertyDataSource(){
        list.add(new Property(R.drawable.mm,"Milutina Milankovica 19B","200$"));
        list.add(new Property(R.drawable.moler,"Kralja Aleksandra 20A","300$"));
        list.add(new Property(R.drawable.omlad,"Nedeljka Cabrinovica 21","250$"));
        list.add(new Property(R.drawable.kraljam,"Rasinska 32","300$"));
        list.add(new Property(R.drawable.kraljicem,"Bratislave Petrovic BB","230$"));
        list.add(new Property(R.drawable.vojvodes,"Bulevar vojvode Misica","320$"));

    }

    public static PropertyDataSource getInstance() {

        if (null == instance) {
            instance = new PropertyDataSource();
        }

        return instance;
    }

    public Property get(int id){
        return  list.get(id);
    }

    public void set(int id,Property property){
        list.add(id,property);
    }

    public void add(Property property){
        list.add(property);
    }

    public String[] getNames(){
        String[] names = new String[list.size()];

        for(int i=0; i< list.size(); i++){
            names[i] = list.get(i).getName();
        }
        return names;
    }
}
