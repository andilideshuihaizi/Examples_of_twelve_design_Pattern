package com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern;

/**
 * RefinedAbstraction修正抽象化角色
 */
public class ConvertToPdfFile extends ConvertDataToFile {


    public ConvertToPdfFile(DBConnection dbConnection) {
        super(dbConnection);
    }

    @Override
    public String convertToFile() {
        this.getConnection();

        return "转换为pdf文件";
    }
}
