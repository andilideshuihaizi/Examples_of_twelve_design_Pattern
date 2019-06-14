package com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern;

import java.sql.Connection;

/**
 *  Implementor实现化角色
 */
public interface DBConnection {

    String getConnection();
}
