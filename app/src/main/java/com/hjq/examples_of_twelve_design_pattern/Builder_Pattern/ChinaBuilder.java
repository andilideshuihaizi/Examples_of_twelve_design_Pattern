package com.hjq.examples_of_twelve_design_pattern.Builder_Pattern;

/**
 * 建造者实现类
 */
public class ChinaBuilder extends Builder {

    private GameRole gameRole;

    public ChinaBuilder() {
        gameRole = new GameRole();
    }

    @Override
    public void buildSkinColor() {
        gameRole.setSkinColor("黄色皮肤");
    }

    @Override
    public void buildHeight() {
        gameRole.setHeight("身高175cm");
    }

    @Override
    public void buildWeight() {
        gameRole.setWeight("体重75kg");
    }

    @Override
    public GameRole buildGameRole() {
        return gameRole;
    }
}
