package com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern;

/**
 * 具体的装饰类
 */
public class YellowAnimalDecotator extends AnimalDecorator{

    public YellowAnimalDecotator(Animal animal) {
        super(animal);
    }

    @Override
    public String getGame() {
        return super.getGame()+"YellowAnimalDecotator";
    }
}
