package com.hjq.examples_of_twelve_design_pattern.Flyweight_Pattern;

/**
 * Created by Administrator on 2019/6/14.
 */
public class Circle implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;
    private boolean ret;

    public Circle(String color) {
        this.color = color;
        ret = false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String draw() {
        return (!ret?first():"") +" Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius;
    }

    private String first(){
        ret = true;
        return "first create and";
    }
}
