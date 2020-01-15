package io.techleadacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.techleadacademy.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyMapaSel {
    ReusableMethods methods = new ReusableMethods();
    @Test // to make it run call annotation @Test
    public void myMapToGo () throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        driver.get("http://googlemaps.com");
        WebElement sighIn_Button = driver.findElement(By.id("searchboxinput"));
        sighIn_Button.sendKeys("Guatemala, Pasaco, Jutiapa");
        sighIn_Button.click();
        WebDriverWait explicit = new WebDriverWait(driver, 5);// EXPLICIT WAIT FOR EACH ELEMENT WE NEED FOR
        driver.findElement(By.id("sbse0")).click();
        WebElement getPicture = driver.findElement(By.xpath("//img[@src='https://lh5.googleusercontent.com/p/AF1QipMYI8cVxg7-1N6KVmBdYY5CL1QwmKRo4bJRczll=w426-h240-k-no']"));
        getPicture.click();
        WebElement buttonBackTo = driver.findElement(By.xpath("//img[@src='//www.gstatic.com/images/icons/material/system_gm/1x/arrow_back_gm_grey_24dp.png']"));
        buttonBackTo.click();
        Thread.sleep(2000);
        WebElement buttHamburgToChoose = driver.findElement(By.xpath("//div[@class='widget-settings-earth-item']"));
        action.moveToElement(buttHamburgToChoose).perform();
        explicit.until(ExpectedConditions.visibilityOf(buttHamburgToChoose));
        WebElement satteliteMap = driver.findElement(By.name("widget-settings-button-label"));
        satteliteMap.click();

    }


}
