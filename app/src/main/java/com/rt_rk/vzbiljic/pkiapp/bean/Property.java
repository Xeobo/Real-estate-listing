package com.rt_rk.vzbiljic.pkiapp.bean;

import java.util.ArrayList;

/**
 * Created by Xeobo on 2/4/2017.
 */

public class Property implements IBean{
    private int image;
    private String name;
    private String price;

    public Property(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
