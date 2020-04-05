package com.limlab.kotlinsample;

import org.junit.Assert;
import org.junit.Test;

public class JavaTest {
    @Test
    public void testFruitHashCode() {
        FruitJava fruitJava1 = new FruitJava();
        FruitJava fruitJava2 = new FruitJava();

        fruitJava1.fruitName = "바나나";
        fruitJava2.fruitName = "바나나";

        fruitJava1.description = "바나나는 길다";
        fruitJava2.description = "바나나는 길다";

        Assert.assertEquals(fruitJava1.hashCode(), fruitJava2.hashCode());
    }
}
