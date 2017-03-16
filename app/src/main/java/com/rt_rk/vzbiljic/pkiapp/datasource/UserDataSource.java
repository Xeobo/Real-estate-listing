package com.rt_rk.vzbiljic.pkiapp.datasource;

import com.rt_rk.vzbiljic.pkiapp.bean.User;

/**
 * Created by vzbiljic on 14.3.17..
 */

public class UserDataSource extends AbstractDataSource<User> {

    private static UserDataSource instance;

    private User currentUser;

    private UserDataSource(){
        add(new User("user","user"));
        add(new User("Pera","Pera"));
        add(new User("Djoka","Djoka"));
        add(new User("Marko","Marko"));
        add(new User("Stefan","Stefan"));
        add(new User("Milos","Milos"));
    }

    public static UserDataSource getInstance(){
        if(null == instance){
            instance = new UserDataSource();
        }
        return instance;
    }


    @Override
    protected String getDescription(User object) {
        return object.getUsername();
    }


    public User getCurrentUser(){
        return currentUser;

    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public int getID(User user){
        return list.indexOf(user);
    }
}
