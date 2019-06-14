package com.hjq.examples_of_twelve_design_pattern.Facade_Pattern;

/**
 * 模块
 */
public class Price {

    private static final String[] products = {"apple","banana","melon"};

    public double getPrice(String product){//"获取产品价格"

        for (String str : products){
            if (str.equals(product)) {
                if (str.equals("apple"))
                    return 5.6;
                if (str.equals("banana"))
                    return 3.2;
                if (str.equals("melon"))
                    return 7;
            }
        }

        return -1;
    }

}
