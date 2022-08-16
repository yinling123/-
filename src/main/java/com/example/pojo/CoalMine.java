package com.example.pojo;


import java.sql.Timestamp;

public class CoalMine {

    private int index;
    private int area;
    private Timestamp datetime;
    private String type;
    private int length;
    private int width;

    public CoalMine(int area, Timestamp datetime, String type, int length, int width) {
        this.area = area;
        this.datetime = datetime;
        this.type = type;
        this.length = length;
        this.width = width;
    }

    public CoalMine(){

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "CoalMine{" +
                "index=" + index +
                ", area=" + area +
                ", datetime=" + datetime +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
