package com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern;

/**
 * 工厂实现类
 */
public class BananaUnPackFactory implements Factory {
    @Override
    public Fruit getFruit() {
        return new Banana();
    }

    @Override
    public Box getBox() {
        return new BananaBox();
    }
}
