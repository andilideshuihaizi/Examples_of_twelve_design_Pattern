package com.hjq.examples_of_twelve_design_pattern.Flyweight_Pattern;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/6/14.
 */
public class ShapeFactory {

    private static final HashMap<String,Shape> list = new HashMap<>();

    public static Shape getCircle(String color){

        Circle circle = (Circle) list.get(color);

        if (circle==null){
            circle = new Circle(color);
            list.put(color,circle);
        }

        return circle;

    }
}
