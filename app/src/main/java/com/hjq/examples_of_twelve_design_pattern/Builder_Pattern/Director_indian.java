package com.hjq.examples_of_twelve_design_pattern.Builder_Pattern;

/**
 * Created by Administrator on 2019/6/5.
 */
public class Director_indian extends Director {

    private addIndiaBuilder builderIndian;

    public Director_indian(addIndiaBuilder builder) {
        super(builder);
        builderIndian = builder;
    }

    public GameRole getGameRole(){
        super.getGameRole();
        builderIndian.buildName();
        return builderIndian.buildGameRole();
    }
}
