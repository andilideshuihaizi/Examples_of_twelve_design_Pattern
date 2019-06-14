package com.hjq.examples_of_twelve_design_pattern.Adapter_Pattern;

/**
 * 对象适配器
 */
public class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String method() {
        return adaptee.AdapteeMethod();
    }
}
