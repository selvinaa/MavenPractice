package io.techleadacademy.Jan12;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {
    @DataProvider(name = "dataName")
    public Object[][] testData(){
    Object[][] data = new Object[3][2];
    data [0][0]=2+2;//actual data
    data [0][1]=4;// expected data
    data [1][0]=200+50;
    data [1][1]=250;
    data [2][0]=-300+20;//actual as it is
    data [2][1]=-280;// expected form 300+20=320
    return data;
}

    @Test(dataProvider = "dataName")// this avoid hard codding numbers or any data
    public void additionTest(int actual, int expected){
//        int actual = a + b;
//        int expected = 4;
        System.out.println("Actual: " + actual + " Expected" + expected);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void additionTest1(){
        int actual = 2000 + 200;
        int expected = 2200;
        System.out.println("Actual: " + actual + " | Expected" + expected);
        Assert.assertEquals(actual,expected);
    }

}
