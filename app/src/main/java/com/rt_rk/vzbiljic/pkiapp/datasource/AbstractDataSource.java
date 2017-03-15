package com.rt_rk.vzbiljic.pkiapp.datasource;

import com.rt_rk.vzbiljic.pkiapp.bean.Comment;
import com.rt_rk.vzbiljic.pkiapp.bean.IBean;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Xeobo on 2/4/2017.
 */

public abstract class AbstractDataSource<T extends IBean>{

    protected ArrayList<T> list = new ArrayList<>();

    protected abstract String getDescription(T object);

    public T get(int id){
        return  list.get(id);
    }

    public void set(int id,T t){
        list.add(id,t);
    }

    public boolean add(T t){
        return list.add(t);
    }

    public T remove(int index){
        return list.remove(index);
    }

    public String[] getDescription(){
        String[] names = new String[list.size()];

        for(int i=0; i< list.size(); i++){
            names[i] = getDescription(list.get(i));
        }
        return names;
    }

}
