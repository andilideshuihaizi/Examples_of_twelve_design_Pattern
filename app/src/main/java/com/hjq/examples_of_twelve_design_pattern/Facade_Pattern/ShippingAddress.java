package com.hjq.examples_of_twelve_design_pattern.Facade_Pattern;

/**
 * 模块
 */
public class ShippingAddress {

    private static final String[] users = {"xiao","fei","long"};

    public String getShippingAddress(String user){//"查询客户的收货地址"


        for (String str : users){
            if (user.equals(str)&&str.equals("xiao"))
                return "xi bu";
            if (user.equals(str)&&str.equals("fei"))
                return "dong bu";
            if (user.equals(str)&&str.equals("long"))
                return "nan bu";
        }

        return "";
    }
}
