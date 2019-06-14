package com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type;


/**
 * Leaf叶子构件
 */
public class File extends AbstractFile{

    public File(String name) {
        super(name);
    }

    @Override
    String print(String string) {
        return "file:" + this.getName();
    }
}
