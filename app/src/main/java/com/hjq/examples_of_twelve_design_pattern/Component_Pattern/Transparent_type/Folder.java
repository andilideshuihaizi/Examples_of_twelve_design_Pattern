package com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Transparent_type;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite树枝构件
 */
public class Folder extends AbstractFile{

    private List<AbstractFile> fileList = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public String add(AbstractFile abstractFile) {
        fileList.add(abstractFile);

        return Integer.toString(fileList.size());
    }

    @Override
    public String remove(AbstractFile abstractFile) {
        boolean ret = false;
        if (fileList.contains(abstractFile)) {
            fileList.remove(abstractFile);
            ret = true;
        }

        return ret?Integer.toString(fileList.size()):"-1";
    }

    @Override
    public String print(String string) {
        String str = "";
        for (AbstractFile s:fileList){
            str += s.print(string)+"\t";
        }
        return str.isEmpty()?"":str+"\n";
    }
}
