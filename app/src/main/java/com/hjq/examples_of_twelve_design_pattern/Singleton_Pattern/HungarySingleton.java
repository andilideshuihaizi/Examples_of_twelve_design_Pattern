package com.hjq.examples_of_twelve_design_pattern.Singleton_Pattern;

import java.io.Serializable;

/**
 * 饿汉式.
 */
public class HungarySingleton implements Serializable {

    private static final HungarySingleton hungarySingleton = new HungarySingleton();

    private HungarySingleton() {
        if (hungarySingleton!=null){
            throw new RuntimeException("单例模式不允许调用构造方法实例化");//通过构造方法防御
        }
    }

    public static HungarySingleton getInstance(){
        return hungarySingleton;
    }

    // 加上该方法在反序列化的时候返回已存在的单例对象
    public Object readResolve() {
        return hungarySingleton;
    }// 防御方式：单例模式中增加反序列化方法，该方法隐式调用。

}

/*
        HungarySingleton hungarySingleton = HungarySingleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singletion"));
        objectOutputStream.writeObject(hungarySingleton);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singletion"));
        HungarySingleton hungarySingleton01 = (HungarySingleton) objectInputStream.readObject();

        System.out.println(hungarySingleton == hungarySingleton01);  // false
 */