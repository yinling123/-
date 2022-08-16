package com.example.pojo;

/**
 * 用于表示解析后返回的值
 */

public class Analysis {

    private String type;
    private int length;
    private int width;

    public Analysis(String type, int length, int width) {
        this.type = type;
        this.length = length;
        this.width = width;
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
        return "Analysis{" +
                "type='" + type + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
