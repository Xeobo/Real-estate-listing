package com.rt_rk.vzbiljic.pkiapp.utils;

import com.rt_rk.vzbiljic.pkiapp.bean.Activity;
import com.rt_rk.vzbiljic.pkiapp.bean.Comment;

import java.util.ArrayList;

/**
 * Created by vzbiljic on 13.3.17..
 */

public class CommentDataSource {


    private ArrayList<Comment> list = new ArrayList<>();

    private static CommentDataSource instance = null;


    private CommentDataSource(){
        list.add(new Comment("Nekretnina dolazi sa poklonom za vreme black friday vikenda. Molimo vas sto pre obezbedite sebi ovu neverovatnu ponudu. Vidimo se sto pre","Jovan","16:44 Jun 23.2017."));
        list.add(new Comment("Koje boje je tepih ovde?","Goran","17:44 Jun 23.2017."));
        list.add(new Comment("Zute. Pozdrav","Jovan","18:33 Jun 23.2017."));


    }

    public static CommentDataSource getInstance() {

        if (null == instance) {
            instance = new CommentDataSource();
        }

        return instance;
    }

    public Comment get(int id){
        return  list.get(id);
    }

    public void set(int id,Comment comment){
        list.add(id,comment);
    }

    public void add(Comment comment){
        list.add(comment);
    }

    public String[] getUsers(){
        String[] names = new String[list.size()];

        for(int i=0; i< list.size(); i++){
            names[i] = list.get(i).getUser();
        }
        return names;
    }
}
