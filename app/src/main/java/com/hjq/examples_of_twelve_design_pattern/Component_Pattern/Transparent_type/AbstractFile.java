package com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Transparent_type;

/**
 * Component抽象构建角色
 */
public abstract class AbstractFile {

    private String name;

    public AbstractFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract String add(AbstractFile abstractFile);
    abstract String remove(AbstractFile abstractFile);
    abstract String print(String string);
}
