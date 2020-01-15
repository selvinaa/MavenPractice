package io.techleadacademy;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
@Test
public class TestTag2 {
    ReusableMethods methods = new ReusableMethods();

    @Test(description = "Adding possitive numbers")// is not vissible to scren but to report yes.
    public void add1(Method method) {
        int actual = 6;
        Assert.assertTrue(actual == 6);
        Test test = method.getAnnotation(Test.class);
        System.out.println(test.description());
    }

    @Test(description = "Testing Negative Numbers")
    public void _00add2() {
        int actual = -5;
        Assert.assertTrue(actual == -10 + 5);
    }

    @Test(priority = -1, groups = {"smoke test", "regression"})// this is the way to prioritize in certain order// in which order to run
    public void subtract() {
        int actual = 3;
        Assert.assertEquals(actual, 6 - 3);
    }

    @Test(priority = -2)
    public void subtract2() {
        int actual = -2;
        Assert.assertEquals(actual, -1-1);
    }

    @Test(groups = {"Smoke Test"})
    public void multiply() {

    }

    @Test(expectedExceptions = ArithmeticException.class)//the way to pass it without any problems
    public void div() {
        Assert.assertEquals(4 / 0, 0);// may get a exception
    }

    // THE WAY TO EXPECT ANY LIST EXCEPTION, IF IS ONLY ONE THEN JUST DECLARE ONE.
    @Test(expectedExceptions = {NoSuchElementException.class,
            ArithmeticException.class, ElementNotInteractableException.class})//the way to pass it without any problems
    public void div2() {
        Assert.assertEquals(4 / 0, 0);// may get a exception
    }

    @Test(enabled = false)// to test it, if you put false it will work even if is not good, do true which is correct
    public void signUp() {
        String invalidPassword = " ";
        String validPassword = "123456";
        Assert.assertTrue(invalidPassword.equals(validPassword));
    }

    @Test(invocationCount = 3)// it will run how many time we need now will be 3 as declare
    public void loginPerformanceTest() {
        System.out.println("Checking log in time");
    }

    @Test(invocationCount = 3, invocationTimeOut = 2000)// it will run how many time we need now will be 3 as declare
    public void loginPerformanceTest2() {
        System.out.println("Checking log in time 2");
        methods.sleep(5000);
    }

    @Test(invocationCount = 10, skipFailedInvocations = true)
// it will run how many time we need now will be 3 as declare
    public void loginPerformanceTest3() {
        System.out.println("Checking log in time 2");
        Assert.fail();
    }

    @Test(timeOut = 4000)
    public void methodTimeOut() {
        Assert.assertTrue(true);
    }

    @Parameters({"username", "password"})
    @Test
    public void testUserName1(@Optional("XX") String username, @Optional("55") String password) {
        String actual = "AAA";
        String expected = username;
        Assert.assertEquals(actual,expected);
        System.out.println("username:" + username);

    }
}