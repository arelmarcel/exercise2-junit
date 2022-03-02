package com.mitrais;

public class Users {
    private String name;
    private Integer point;
    private Integer id;

    //setter

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public void addPoint(Integer value) {this.point = this.point + value;};
    public void reducePoint(Integer value) {this.point = this.point - value;}
    //getter

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPoint() {
        return point;
    }
}
