package com.rt_rk.vzbiljic.pkiapp.bean;

/**
 * Created by Xeobo on 2/4/2017.
 */

public class Property implements IBean{
    private int image;
    private String name;
    private String price;
    private int surfaceArea;
    private String structure;
    private String flor;
    private String heating;
    private String terrace;
    private String dateFrom;
    private String booked;
    private String status;
    private String type;


    public Property(int image, String name, String price, int surfaceArea, String structure, String flor, String heating, String terrace, String type, String dateFrom, String booked, String status) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.surfaceArea = surfaceArea;
        this.structure = structure;
        this.flor = flor;
        this.heating = heating;
        this.terrace = terrace;
        this.type = type;
        this.dateFrom = dateFrom;
        this.booked = booked;
        this.status = status;
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

    public int getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(int surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getFlor() {
        return flor;
    }

    public void setFlor(String flor) {
        this.flor = flor;
    }

    public String getHeating() {
        return heating;
    }

    public void setHeating(String heating) {
        this.heating = heating;
    }

    public String getTerrace() {
        return terrace;
    }

    public void setTerrace(String terrace) {
        this.terrace = terrace;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBooked() {
        return booked;
    }

    public void setBooked(String booked) {
        this.booked = booked;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
