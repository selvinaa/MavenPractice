package io.techleadacademy;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrangeHomeWork {
    WebDriver driver;

    @Test
    public void projectDay() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/Users/test/IdeaProjects/Drivers/chromedriver");// no longer need it.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get(("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard"));
        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();
        String mainWindow = driver.getWindowHandle();// main Window to come baack
        driver.findElement(By.xpath("//a[@data-username='admin']")).click();
        driver.findElement(By.xpath("//span[@class='material-icons collapsible-indicator']")).click();
        driver.findElement(By.xpath("(//span[@class='material-icons collapsible-indicator'])[27]")).click();
        driver.findElement(By.id("menu_news_viewNewsList")).click();
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.id("noncoreIframe")));

        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='dataRaw']"));// 50 items inside
        System.out.println(list.size());
        for (WebElement eachList : list) {
            System.out.println(eachList.getText());
        }//3,6,7.items on column
        Map<String, List<String>> map1 = new HashMap<>();
        for (WebElement eachElem : list) {
            String key = eachElem.findElement(By.xpath(".//td[2]")).getText();// this is our Key
            List<String> innerList = new ArrayList<>();
            String date = eachElem.findElement(By.xpath(".//td[3]")).getText();
            innerList.add(date);
            String userRole = eachElem.findElement(By.xpath(".//td[6]")).getText();
            innerList.add(userRole);

            if (eachElem.findElement(By.xpath(".//td[7]//i")).getAttribute("class").contains("disabled")) {
                innerList.add("Attachment - NO");
            } else {
                innerList.add("Attachment - YES");
            }
            map1.put(key, innerList);

        }
        for (String key2 : map1.keySet()) {
            System.out.print(key2);// no ln for better print out
            for (String s : map1.get(key2)) {
                System.out.print(" | " + s);//no ln for better print out
            }
            System.out.print("\n");// no ln for better print out
        }




        //}
        // get into plus icon and add all info for awards

        WebElement plusIcon = driver.findElement(By.id("list_item_add"));//
        //method.waitForClickability(driver, plusIcon)

        plusIcon.click();
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        WebElement topic = driver.findElement(By.id("news_topic"));
        Thread.sleep(2000);
        topic.click();
        action.moveToElement(topic).sendKeys("Congratulations Selvin").click().perform();
        driver.switchTo().frame(driver.findElement(By.id("news_description_ifr")));// 2 frame in use

        LocalDate theDay = LocalDate.now();// to get the currect day of any change
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String today = df.format(theDay);
        driver.findElement(By.id("tinymce")).sendKeys("Promotion was awarded to Selvin" + theDay);
        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='nextBtn']"));
        action.moveToElement(sendButton).click().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Publish To - All User Roles']")).click();
        WebElement publish = driver.findElement(By.xpath("//button[@btn-type='publish']"));
        Thread.sleep(2000);
        publish.click();
        Thread.sleep(3000);
        driver.findElement(By.id("user-dropdown")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("logoutLink")).click();
        Thread.sleep(4000);
        WebElement sighInAgain = driver.findElement(By.xpath("//button[@type='button']"));
        sighInAgain.click();

        WebElement sseBut = driver.findElement(By.xpath("(//a[@class='login-as'])[3]"));
        action.moveToElement(sseBut).click().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='material-icons collapsible-indicator'])[61]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("account-job")).click();
        //WebElement newsBut = driver.findElement(By.xpath("(//span[@class='left-menu-title'])[75]"));
        //action.moveToElement(newsBut).click().perform();
        Thread.sleep(2000);
        driver.findElement(By.id("logoutLink")).click();// Logging out againt
        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();
        driver.findElement(By.xpath("(//a[@class='login-as'])[2]")).click();






        }


    }

