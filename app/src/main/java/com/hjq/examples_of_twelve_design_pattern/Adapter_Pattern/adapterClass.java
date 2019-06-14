package com.hjq.examples_of_twelve_design_pattern.Adapter_Pattern;

/**
 * 类适配器
 */
public class adapterClass extends Adaptee implements Target{

    private Target target ;
    private Adaptee adaptee;

    public adapterClass(Target target, Adaptee adaptee) {
        this.target = target;
        this.adaptee = adaptee;
    }

    @Override
    public String method() {
        return AdapteeMethod();
    }

}
