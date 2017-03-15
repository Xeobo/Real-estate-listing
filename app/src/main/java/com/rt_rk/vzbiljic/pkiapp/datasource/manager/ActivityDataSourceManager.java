package com.rt_rk.vzbiljic.pkiapp.datasource.manager;

import com.rt_rk.vzbiljic.pkiapp.datasource.ActivityDataSource;

/**
 * Created by vzbiljic on 14.3.17..
 */

public class ActivityDataSourceManager extends AbstractManager<ActivityDataSource> {



    public static ActivityDataSourceManager instance;

    @Override
    protected ActivityDataSource instatiate() {
        return new ActivityDataSource();
    }


    public static ActivityDataSourceManager getInstance(){
        if(null == instance){
            instance = new ActivityDataSourceManager();
        }
        return instance;
    }

}
