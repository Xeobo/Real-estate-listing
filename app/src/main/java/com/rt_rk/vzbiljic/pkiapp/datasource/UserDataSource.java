package com.rt_rk.vzbiljic.pkiapp.datasource;

import com.rt_rk.vzbiljic.pkiapp.bean.User;

/**
 * Created by vzbiljic on 14.3.17..
 */

public class UserDataSource extends AbstractDataSource<User> {

    private static UserDataSource instance;

    private User currentUser;

    private UserDataSource(){
        add(new User("user","user","BG Stan","0631234567"));
        add(new User("Petar","Petar","Life Home","0631234567"));
        add(new User("Janko","Janko","Krov","0631234567"));
        add(new User("Jovan","Jovan","Moje Nekretnine","0631234567"));
        add(new User("Mirko","Mirko","BG Stan","0631234567"));
        add(new User("Đorđe","Đorđe","Krov","0631234567"));
        add(new User("Branko","Branko","City Expert","0631234567"));
        add(new User("Marko","Marko","BG Stan","0631234567"));
        add(new User("Stefan","Stefan","Life Home","0631234567"));
        add(new User("Milos","Milos","Krov","0631234567"));
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

    public boolean checkIfUserExists(String user) {
        for(int i=0; i< UserDataSource.getInstance().size();i++){
            User u = UserDataSource.getInstance().get(i);
            if(u.getUsername().equals(user)) {
                return true;
            }
        }
        return false;
    }
}
