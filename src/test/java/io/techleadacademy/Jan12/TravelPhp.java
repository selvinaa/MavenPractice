package io.techleadacademy.Jan12;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.techleadacademy.zz_TestNGExamples.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TravelPhp {
    static WebDriver driver;
    static WebDriverWait explicit;

    @Test
    public void getSignUp(){

        ReusableMethods methods = new ReusableMethods();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        //NAVIGATING TO PAGE AND VERIFYING TITLE
        String expectedTitle = "PHPTRAVELS | Travel Technology Partner";
        driver.get("https://phptravels.net/home");
        Assert.assertEquals(driver.getTitle(),expectedTitle);// GETTING EXPECTED TITLE FROM WEB
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Faker faker = new Faker();//         FAKER METHOD
        WebElement signUpButton = driver.findElement(By.xpath("(//a[@class='btn btn-text-inherit btn-interactive'])[3]"));
        signUpButton.click();
        driver.findElement(By.xpath("//a[@class='dropdown-item tr']")).click();
        String passWord = "12345678";
        String[] allPersonalData = {faker.name().firstName(),faker.name().lastName(),faker.phoneNumber().cellPhone()
                ,faker.internet().emailAddress(),passWord,passWord};
        explicit = new WebDriverWait(driver, 5);// APPLYING EXPLICT WAIT
        List<WebElement> listPersonData = driver.findElements(By.xpath("//div[@class='form-group']/input"));// 6 units inside
        for(int i=0; i < listPersonData.size(); i++){
            listPersonData.get(i).sendKeys(allPersonalData[i]);// ITERATIONS BY LOOPING LISTDATA
        }
//        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
//        firstName.sendKeys("Selvin");
//        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
//        lastName.sendKeys("Asencio");
//        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
//        phoneNumber.sendKeys("571-2441419");
//        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
//        email.sendKeys("sasencio82@outlook.com");
//        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//        password.sendKeys("Augusto2030");
//        WebElement rePassWord = driver.findElement(By.xpath("//input[@name='confirmpassword']"));
//        rePassWord.sendKeys("Augusto2030");
//        methods.sleep(2000);
        // SUBMIT INFORMATION
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        System.out.println("================VERIFY IS REGISTERED");
        System.out.println(driver.getTitle());
        // VERIFY ALL INFORMATION BY ASSERTS
        String titleOfPage = "Register";
        Assert.assertEquals(driver.getTitle(),titleOfPage);
        WebElement getName = driver.findElement(By.xpath("//h3[@class='text-align-left']"));
        System.out.println(getName.getText().toUpperCase().length());// GETTING NAME OF ACCOUNT

        String dateNow = "dd MMMMM yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(dateNow);
        Date onlyDay = new Date();// HAVING DATE AND TIME
        String day = formatter.format(onlyDay);
        String  gettingDate = driver.findElement(By.xpath("//span[@class='h4']")).getText();
        System.out.println(gettingDate);
        Assert.assertEquals(day,gettingDate);
       // String str = driver.getTitle();


//        Task Jan - 12
//        1. Navigate to phptravels.net/home
//        2. Verify page title
//        "PHPTRAVELS | Travel Technology Partner"
//        3. Crate a new account:
//        Click on "My account"
//        Click on "Sign Up"
//        Fill Out "Register" form
//        Click Sumbit
//        Verify Sign Up was successfull
//                (How? Assert after you click Submit it takes you to profile page)
//        4. Verify on "Profile page":
//        Title is "My Account"
//        Its says "Hi, firstName LastName"
//        Today's date

    }


}
