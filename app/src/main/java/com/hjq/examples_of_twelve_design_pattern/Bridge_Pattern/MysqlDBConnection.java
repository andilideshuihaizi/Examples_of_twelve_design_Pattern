package com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern;

import java.sql.Connection;

/**
 * ConcreateImplementor具体实现化角色
 */
public class MysqlDBConnection implements DBConnection {

    @Override
    public String getConnection() {
        return "获取mysql数据连接" ;
    }
}
