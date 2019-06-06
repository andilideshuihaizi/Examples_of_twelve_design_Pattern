package com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern;

/**
 * 产品实现类
 */
public class Banana implements Fruit {
    @Override
    public String produce() {
        return "abstract banana.";
    }
}
