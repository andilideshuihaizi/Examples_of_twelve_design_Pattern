package com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern;

/**
 * 装饰角色
 */
public class AnimalDecorator implements Animal {

    private Animal animal;

    public AnimalDecorator(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String getGame() {
        return animal.getGame();
    }

}
