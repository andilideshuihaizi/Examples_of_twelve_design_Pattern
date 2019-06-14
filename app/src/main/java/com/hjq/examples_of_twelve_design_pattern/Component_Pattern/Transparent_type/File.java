package com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Transparent_type;

/**
 * Leaf叶子构件
 */
public class File extends AbstractFile{

    public File(String name) {
        super(name);
    }

    @Override
    final String add(AbstractFile abstractFile) {
        throw new UnsupportedOperationException("文件不允许添加操作");
    }

    @Override
    final String remove(AbstractFile abstractFile) {
        throw new UnsupportedOperationException("文件不允许删除操作");
    }

    @Override
    String print(String string) {
        return "file:" + this.getName();
    }
}
