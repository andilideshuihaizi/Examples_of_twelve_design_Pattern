package com.hjq.examples_of_twelve_design_pattern.Factory_pattern;

/**
 * 工厂实现类
 */
public class BananaFactory implements Factory {
    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}
