package com.hjq.examples_of_twelve_design_pattern.Singleton_Pattern;

/**
 * 枚举单例
 */
public enum EnumSingleton {

    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
