package com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern;

/**
 * ConcreateImplementor具体实现化角色
 */
public class OracleDBConnection implements DBConnection {
    @Override
    public String getConnection() {
        return "获取oracle数据连接";
    }
}
