package io.techleadacademy.tests;

import io.techleadacademy.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageTest extends TestBase {

    public void HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/']/img")
    public WebElement logo;

    @FindBy(xpath = "(//a[@id='dropdownCurrency'])[2]")
    public WebElement myAccount_Btn;

    @FindBy(xpath = "//a[text()='Sign Up']")
    public WebElement signUp_Btn;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement logIn_Btn;

    public void rand(){
        logo.sendKeys();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickMyAccountBtn(){
        myAccount_Btn.click();
    }

    public void clickSignUp(){
        clickMyAccountBtn();
        signUp_Btn.click();
    }
}
