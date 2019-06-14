package com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type;

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

    abstract String print(String string);

    /*
    add()
    remove()等的功能没有在基类中添加，而是放在继承类——树枝上去添加；这样另外的继承类——树叶，就不会必需实现某个method
     */
}
