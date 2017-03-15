package com.rt_rk.vzbiljic.pkiapp.datasource;

import com.rt_rk.vzbiljic.pkiapp.bean.Comment;

/**
 * Created by vzbiljic on 13.3.17..
 */

public class CommentDataSource extends AbstractDataSource<Comment> {

    @Override
    protected String getDescription(Comment object) {
        return object.getUser();
    }

    public CommentDataSource(){
        add(new Comment("Nekretnina dolazi sa poklonom za vreme black friday vikenda. Molimo vas sto pre obezbedite sebi ovu neverovatnu ponudu. Vidimo se sto pre","Jovan","16:44 Jun 23.2017."));
        add(new Comment("Koje boje je tepih ovde?","Goran","17:44 Jun 23.2017."));
        add(new Comment("Zute. Pozdrav","Jovan","18:33 Jun 23.2017."));


    }

}
