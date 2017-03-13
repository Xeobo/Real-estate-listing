package com.rt_rk.vzbiljic.pkiapp.utils;

import com.rt_rk.vzbiljic.pkiapp.bean.Activity;

import java.util.ArrayList;

/**
 * Created by vzbiljic on 13.3.17..
 */

public class ActivityDataSource implements IDataSource {

    private ArrayList<Activity> list = new ArrayList<>();

    private static ActivityDataSource instance = null;


    private ActivityDataSource(){
        list.add(new Activity("23.03.2016.","Petar","Janko", Activity.ActivityType.VISIT));
        list.add(new Activity("23.03.2016.","Jovan","Mirko", Activity.ActivityType.OFFER,500));
        list.add(new Activity("23.03.2016.","Đorđe","Branko", Activity.ActivityType.APPOINTMENT));
        list.add(new Activity("23.03.2016.","Stefan","Branko", Activity.ActivityType.OFFER,300));

    }

    public static ActivityDataSource getInstance() {

        if (null == instance) {
            instance = new ActivityDataSource();
        }

        return instance;
    }

    public Activity get(int id){
        return  list.get(id);
    }

    public void set(int id,Activity ac){
        list.add(id,ac);
    }

    public void add(Activity activity){
        list.add(activity);
    }

    public void remove(int index){
        list.remove(index);
    }

    public String[] getUsers(){
        String[] names = new String[list.size()];

        for(int i=0; i< list.size(); i++){
            names[i] = list.get(i).getUser();
        }
        return names;
    }
}
