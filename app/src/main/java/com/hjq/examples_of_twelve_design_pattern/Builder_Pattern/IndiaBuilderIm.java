package com.hjq.examples_of_twelve_design_pattern.Builder_Pattern;

/**
 * Created by Administrator on 2019/6/5.
 */
public class IndiaBuilderIm extends addIndiaBuilder {

    private Indian gameRole;

    public IndiaBuilderIm() {
        gameRole = new Indian();
    }

    @Override
    public void buildName() {
        gameRole.setName("Indian");
    }

    @Override
    public void buildSkinColor() {
        gameRole.setSkinColor("黄色皮肤 ,too");
    }

    @Override
    public void buildHeight() {
        gameRole.setHeight("身高175cm ,too");
    }

    @Override
    public void buildWeight() {
        gameRole.setWeight("体重75kg , too");
    }

    @Override
    public GameRole buildGameRole() {
        return gameRole;
    }
}
