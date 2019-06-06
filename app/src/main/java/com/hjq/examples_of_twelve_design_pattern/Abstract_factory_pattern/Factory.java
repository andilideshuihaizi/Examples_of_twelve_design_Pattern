package com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern;

/**
 * 工厂接口
 */
public interface Factory {
    Fruit getFruit();
    Box getBox();
}
