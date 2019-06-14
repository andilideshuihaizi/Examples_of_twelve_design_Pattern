package com.hjq.examples_of_twelve_design_pattern.Facade_Pattern;

/**
 * 模块
 */
public class Product {

    private static final String[] products = {"apple","banana","melon"};

    public boolean checkStock(String product ,int num){//"检查库存是否足够"
        for (String str : products){

            if (str.equals(product)) {
                if (str.equals("apple") && num > 50)
                    return true;
                if (str.equals("banana") && num > 20)
                    return true;
                if (str.equals("melon") && num > 40)
                    return true;
            }
        }

        return false;
    }

}
