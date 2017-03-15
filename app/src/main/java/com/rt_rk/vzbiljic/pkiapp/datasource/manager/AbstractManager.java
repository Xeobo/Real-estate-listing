package com.rt_rk.vzbiljic.pkiapp.datasource.manager;

import com.rt_rk.vzbiljic.pkiapp.datasource.AbstractDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.ActivityDataSource;

import java.util.ArrayList;

/**
 * Created by vzbiljic on 14.3.17..
 */

public abstract class AbstractManager<T extends AbstractDataSource> {
    protected ArrayList<T> arrayList = new ArrayList<>();


    protected abstract T instatiate();


    public T getDataSource(int i){
        if( i >= arrayList.size()){
            arrayList.add(i, instatiate());
        }

        return arrayList.get(i);
    }

    public int size(){
        return arrayList.size();
    }

    public boolean remove(int i){
        if( i < arrayList.size()){
            arrayList.remove(i);
            return true;
        }
        return false;
    }

}
