package com.hjq.examples_of_twelve_design_pattern.Builder_Pattern;

/**
 * Created by Administrator on 2019/6/5.
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public GameRole getGameRole(){
        builder.buildSkinColor();
        builder.buildHeight();
        builder.buildWeight();
        return builder.buildGameRole();
    }
}
