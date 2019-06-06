package com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern;

/**
 * 工厂实现类
 */
public class AppleUnPackFactory implements Factory {
    @Override
    public Fruit getFruit() {
        return new Apple();
    }

    @Override
    public Box getBox() {
        return new AppleBox();
    }
}
