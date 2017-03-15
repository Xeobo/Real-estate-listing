package com.rt_rk.vzbiljic.pkiapp.datasource.manager;

import com.rt_rk.vzbiljic.pkiapp.datasource.CommentDataSource;

/**
 * Created by vzbiljic on 14.3.17..
 */

public class CommentDataSourceManager extends AbstractManager<CommentDataSource> {


    public static CommentDataSourceManager instance;

    @Override
    protected CommentDataSource instatiate() {
        return new CommentDataSource();
    }

    public static CommentDataSourceManager getInstance(){
        if(null == instance){
            instance = new CommentDataSourceManager();
        }
        return instance;
    }
}
