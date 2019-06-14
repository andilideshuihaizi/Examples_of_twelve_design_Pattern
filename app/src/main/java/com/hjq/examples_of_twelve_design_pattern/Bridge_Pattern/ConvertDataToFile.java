package com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern;

import java.sql.Connection;

/**
 * Abstraction抽象化角色
 */
public abstract class ConvertDataToFile {
    private DBConnection dbConnection;

    public ConvertDataToFile(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getConnection(){
        return this.dbConnection.getConnection();
    }

    public abstract String convertToFile();
}
