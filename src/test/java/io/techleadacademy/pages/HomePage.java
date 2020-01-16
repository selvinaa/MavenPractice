package io.techleadacademy.pages;

import io.techleadacademy.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;

public class HomePage extends TestBase {// WE ARE EXTENDING ALL OUR METHODS FROM TESTBASE CLASS TO REACH ANY WEB

    public HomePage() {
        PageFactory.initElements(driver, this);// CONNECTING OUR WEB BY PAGE-FACTORY
    }

    @FindBy(xpath = "//a[@href='https//www.phptravels.net/']/img")
    public WebElement logo;// NAME OF THE LOGO OF PAGE


    @FindBy(xpath = "//a[@id='dropdownCurrency'][2]")
    public WebElement myAccount_Btn;

    public String getTitle() {
        return driver.getTitle();

    }
}
