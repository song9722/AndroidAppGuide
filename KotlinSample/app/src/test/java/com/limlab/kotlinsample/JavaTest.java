package com.limlab.kotlinsample;

import org.junit.Assert;
import org.junit.Test;

public class JavaTest {
    @Test
    public void testExtFunc() {
        String lastString = StringExtKt.lastString("apple");
        Assert.assertEquals("e", lastString);
    }
}
