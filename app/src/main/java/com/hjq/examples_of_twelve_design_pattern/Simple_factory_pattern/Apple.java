package com.hjq.examples_of_twelve_design_pattern.Simple_factory_pattern;

/**
 * 产品的实现类
 */
public class Apple implements Fruit {

    @Override
    public String produce() {
        return "this is apple";
    }
}
