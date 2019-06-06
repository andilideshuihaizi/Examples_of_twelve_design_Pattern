package com.hjq.examples_of_twelve_design_pattern.Builder_Pattern;

/**
 * 建造者抽象类
 */
public abstract class Builder {
    public abstract void buildSkinColor();
    public abstract void buildHeight();
    public abstract void buildWeight();
    public abstract GameRole buildGameRole();

}
