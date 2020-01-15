package io.techleadacademy.zz_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingTestNG {
    @Test
    public void testTwoNums(){
        int actualNum = 9;
        int expectedNum = 9;
        Assert.assertEquals(actualNum, expectedNum);
    }
}
