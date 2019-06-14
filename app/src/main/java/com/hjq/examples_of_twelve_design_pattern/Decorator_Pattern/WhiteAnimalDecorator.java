package com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern;

/**
 * 具体的装饰类
 */
public class WhiteAnimalDecorator extends AnimalDecorator {

    public WhiteAnimalDecorator(Animal animal) {
        super(animal);
    }

    @Override
    public String getGame() {
        return super.getGame()+"WhiteAnimalDecorator";
    }
}
