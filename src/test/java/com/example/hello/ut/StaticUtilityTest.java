package com.example.hello.ut;

import com.example.hello.StaticUtility;
import org.junit.Assert;
import org.junit.Test;

public class StaticUtilityTest {
    @Test
    public void staticMethod() {
        Assert.assertEquals("Static value", StaticUtility.staticMethod());
    }
}
