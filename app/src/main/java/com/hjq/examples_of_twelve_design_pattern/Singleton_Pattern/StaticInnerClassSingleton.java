package com.hjq.examples_of_twelve_design_pattern.Singleton_Pattern;

/**
 * 静态内部类
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
        if (InnerClass.staticInnerClassSingleton!=null){
            throw new RuntimeException("单例模式不允许调用构造方法实例化");//通过构造方法防御
        }
    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.staticInnerClassSingleton;
    }

    private static class InnerClass{
        private static final StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }
}
