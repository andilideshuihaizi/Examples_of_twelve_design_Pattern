package com.hjq.examples_of_twelve_design_pattern.Singleton_Pattern;

import java.io.Serializable;

/**
 * 懒汉式
 */
public class LazySingleton implements Serializable {

    private static LazySingleton lazySingleton=null;

    private LazySingleton(){
        if (lazySingleton!=null){
            throw new RuntimeException("单例模式不允许调用构造方法实例化");//通过构造方法防御
        }
    }

    public static LazySingleton getInstance(){
        synchronized (LazySingleton.class){
            if (lazySingleton == null){
                lazySingleton = new LazySingleton();
            }
        }
        return lazySingleton;
    }

    // 加上该方法在反序列化的时候返回已存在的单例对象
    public Object readResolve() {
        return lazySingleton;
    }// 防御方式：单例模式中增加反序列化方法，该方法隐式调用。

}
