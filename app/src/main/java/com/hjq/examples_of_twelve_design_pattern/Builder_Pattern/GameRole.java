package com.hjq.examples_of_twelve_design_pattern.Builder_Pattern;

/**
 * 产品类(可定义为抽象产品类)
 */
public class GameRole {
    private String skinColor;
    private String height;
    private String weight;

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
