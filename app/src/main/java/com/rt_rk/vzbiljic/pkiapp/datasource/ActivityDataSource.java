package com.rt_rk.vzbiljic.pkiapp.datasource;

import com.rt_rk.vzbiljic.pkiapp.bean.Activity;

/**
 * Created by vzbiljic on 13.3.17..
 */

public class ActivityDataSource extends AbstractDataSource<Activity> {


    @Override
    protected String getDescription(Activity object) {
        return object.getUser();
    }

    public ActivityDataSource() {
        add(new Activity("23.03.2016.", "Petar", "Janko", Activity.ActivityType.VISIT));
        add(new Activity("23.03.2016.", "Jovan", "Mirko", Activity.ActivityType.OFFER, 500));
        add(new Activity("23.03.2016.", "Đorđe", "Branko", Activity.ActivityType.APPOINTMENT));
        add(new Activity("23.03.2016.", "Stefan", "Branko", Activity.ActivityType.OFFER, 300));

    }

}
