package com.hjq.examples_of_twelve_design_pattern.Singleton_Pattern;

import java.io.Serializable;

/**
 * 双重检查式
 */
public class DoubleCheckSingleton implements Serializable {

    private volatile static DoubleCheckSingleton doubleCheckSingleton = null;

    private DoubleCheckSingleton() {
        if (doubleCheckSingleton!=null){
            throw new RuntimeException("单例模式不允许调用构造方法实例化");
        }
    }

    public static DoubleCheckSingleton getInstance(){
        if (doubleCheckSingleton == null){
            synchronized (DoubleCheckSingleton.class){
                if (doubleCheckSingleton == null){
                    // 1、分配内存给对象
                    // 2、初始化对象
                    // 3、对象赋值给doubleCheckSingleton
                    // jvm的指令重排可能会使得2和3这两步顺序不确定
                    // 当执行顺序是1->3->2的时候，就会出现问题，此时doubleCheckSingleton不为空，别的线程来获取这个单例对象
                    // 时就可能拿到还没初始化的这个对象，此时如果别的线程直接使用，就会出错。因此加上volatile禁止jvm指令重排
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }

        return doubleCheckSingleton;
    }

    // 加上该方法在反序列化的时候返回已存在的单例对象
    public Object readResolve() {
        return doubleCheckSingleton;
    }// 防御方式：单例模式中增加反序列化方法，该方法隐式调用。
}
