package com.hjq.examples_of_twelve_design_pattern.Simple_factory_pattern;

/**
 * 简单工厂类
 */
public class FruitFactory {

    public Fruit getFruit(String fruitname){
        if ("apple".equals(fruitname)){
            return new Apple();
        }else if ("banana".equals(fruitname)){
            return new Banana();
        }else
            return null;
    }

}
