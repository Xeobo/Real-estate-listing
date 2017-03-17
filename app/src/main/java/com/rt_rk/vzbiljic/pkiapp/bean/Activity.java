package com.rt_rk.vzbiljic.pkiapp.bean;

import android.os.IBinder;

/**
 * Created by vzbiljic on 13.3.17..
 */

public class Activity implements IBean{
    private String datum, user,agent;
    private ActivityType type;
    private int amount;


    public Activity(String datum, String user, String agent,ActivityType type,int amount) {
        this.datum = datum;
        this.user = user;
        this.agent = agent;
        this.type = type;
        this.amount = amount;
    }

    public Activity(String datum, String user, String agent,ActivityType type) {
        this.datum = datum;
        this.user = user;
        this.agent = agent;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public String toString(){
        return type.toString(this);
    }

    public enum ActivityType{
        VISIT,
        OFFER,
        APPOINTMENT;

        private String toString(Activity activity){
             switch (this){
                 case VISIT: return "obilazak";
                 case OFFER: return "ponuda: " + activity.amount;
                 case APPOINTMENT: return "zakazan";
                 default: return "drugi tip";
             }
        }
        public static String[] stringValues(){
            return new String[]{
                    "obilazak",
                    "ponuda",
                    "zakazan"
            };

        }
        public static ActivityType fromString(String value){
            switch (value){
                case "obilazak": return VISIT;
                case "ponuda": return OFFER;
                case "zakazan": return APPOINTMENT;
                default: return null;
            }

        }
    }
}
