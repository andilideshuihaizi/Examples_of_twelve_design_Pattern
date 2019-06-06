package com.hjq.examples_of_twelve_design_pattern.Builder_Pattern;

/**
 * Created by Administrator on 2019/6/5.
 */
public class EnglandBuilder extends Builder {

    private GameRole gameRole;

    public EnglandBuilder() {
        gameRole = new GameRole();
    }

    @Override
    public void buildSkinColor() {
        gameRole.setSkinColor("白色皮肤");
    }

    @Override
    public void buildHeight() {
        gameRole.setHeight("身高185cm");
    }

    @Override
    public void buildWeight() {
        gameRole.setWeight("体重85kg");
    }

    @Override
    public GameRole buildGameRole() {
        return gameRole;
    }
}
