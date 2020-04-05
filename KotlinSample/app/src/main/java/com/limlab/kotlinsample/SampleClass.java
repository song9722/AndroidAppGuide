package com.limlab.kotlinsample;

public class SampleClass {
    int outerField = 0;

    class InnerClass {
        int myField = outerField;
    }

    public static class NestedClass {

    }
}
