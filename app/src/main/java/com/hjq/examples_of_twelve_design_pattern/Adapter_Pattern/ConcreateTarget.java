package com.hjq.examples_of_twelve_design_pattern.Adapter_Pattern;

/**
 * ConcreateTarget
 */
public class ConcreateTarget implements Target {

    @Override
    public String method() {
        return "ConcreateTarget";
    }
}
