package io.techleadacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.techleadacademy.zz_TestNGExamples.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Orange2LongWay {

    ReusableMethods methods = new ReusableMethods();
        @Test
        public void verifyPageTitle_orangeHRM() throws InterruptedException {
            //SET UP
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            Actions action = new Actions(driver);
            //NAVIGATING TO PAGE AND VERIFYING TITLE
            String expectedTitle = "OrangeHRM";
            driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
            Assert.assertEquals(driver.getTitle(), expectedTitle);
            //LOG IN AS CERTAIN ROLE (ADMIN)
            WebElement logIn_Btn = driver.findElement(By.id("loginAsButtonGroup"));
            logIn_Btn.click();
            //Existing users are: "ESS User", "1st Level Supervisor", "System Administrator", "Administrator
            WebElement userRole = logIn_Btn.findElement(By.xpath(".//*[.='Administrator']"));
            //CREATING AN EXPLICIT WAIT
            WebDriverWait explicitWait = new WebDriverWait(driver, 10);
            explicitWait.until(ExpectedConditions.visibilityOf(userRole));
            userRole.click();
            //CLICKING OPTIONS IN MENU BAR
            WebElement menuContent = driver.findElement(By.id("menu-content"));
            WebElement adminButton = menuContent.findElement(By.id("menu_admin_viewAdminModule"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(adminButton));
            adminButton.click();
            WebElement announcements = menuContent.findElement(By.id("menu_news_Announcements"));
            announcements.click();
            WebElement news = menuContent.findElement(By.id("menu_news_viewNewsList"));
            news.click();
            //MAIN WINDOW HANDLE
            String mainWindowHandle = driver.getWindowHandle();
            //SWITCHING TO IFRAME
            String mainFrame = "noncoreIframe";
            driver.switchTo().frame(mainFrame);
            //GETTING TABLE DATA ROWS AND SIZE
            List<WebElement> tableRows = driver.findElements(By.className("dataRaw"));
            explicitWait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
            System.out.println(tableRows.size());
            //STORING ALL DATA IN MAPS
//            Map<String, List<String>> allData = new HashMap<>();
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        for (WebElement each: tableRows){
//            String key = each.findElement(By.xpath(".//td[2]")).getText();
//            List<String> values = new ArrayList<>();
//            values.add(each.findElement(By.xpath(".//td[3]")).getText());
//            values.add(each.findElement(By.xpath(".//td[6]")).getText());
//            String attachment = "Attachment - NO";
//            if (each.findElements(By.xpath(".//i[contains(@class,'material-icons attachment  ')]")).size()==1)
//                attachment = "Attachment - YES";
//            values.add(attachment);
//            allData.put(key, values);
//        }
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            //PRINTOUT MAP VALUES IN GIVEN FORMAT: Key | Value1 | Value2 | Value3
//        for (String each: allData.keySet()){
//            System.out.print(each);
//            for(int i = 0; i < allData.get(each).size(); i++) {
//                System.out.print(" | " + allData.get(each).get(i));
//            }
//            System.out.print("\n");
//        }
            //ADDING NEW ANNOUNCEMENT
            WebElement addButton = driver.findElement(By.id("list_item_add"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(addButton));
            addButton.click();
            methods.sleep(3000);
            WebElement formTitle = driver.findElement(By.id("orangehrm-form-title"));
            explicitWait.until(ExpectedConditions.visibilityOf(formTitle));
            WebElement inputTopic = driver.findElement(By.id("news_topic"));
            // to delete any name of the topic input
            String input_topic_text = "Congratulation Selvin";
            inputTopic.sendKeys(input_topic_text);
            //SWITCHING TO INNER IFRAME
            String newDescFrame = "news_description_ifr";
            driver.switchTo().frame(newDescFrame);
            //FORMATTING DATE BASED ON REQUIREMENT
            Date date = new Date();// HAVING DATE AND TIME
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
            String currentDate = formatter.format(date);
            //INPUT DESCRIPTION
            String input_desc_text = "Promotion was awarded to Student on " + currentDate;
            WebElement inputDescription = driver.findElement(By.id("tinymce"));
            inputDescription.sendKeys(input_desc_text);// coming from the message to the student
            //PUBLISHING
            driver.switchTo().parentFrame();
            WebElement nextButton = driver.findElement(By.id("nextBtn"));
            nextButton.click();
            WebElement publishToAll_Btn = driver.findElement(By.xpath("//label[@for='news_publish_all']"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(publishToAll_Btn));
            publishToAll_Btn.click();
            WebElement publish_Btn = driver.findElement(By.xpath("//button[@btn-type='publish']"));
            publish_Btn.click();
            tableRows = driver.findElements(By.className("dataRaw"));
            explicitWait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
            int count = 0;
            for (WebElement element: tableRows){
                if (element.findElement(By.xpath(".//td[2]")).getText().equals(input_topic_text))
                    count++;
            }
            System.out.println(count);
            //VERIFY ANNOUNCEMENT IS PRESENT
            Assert.assertTrue(count > 0);
            System.out.println(tableRows.size());
            //LOG OUT
            WebElement userOptions = driver.findElement(By.id("account-job"));
            userOptions.click();
            WebElement logOut_Btn = driver.findElement(By.id("logoutLink"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(logOut_Btn));
            logOut_Btn.click();
            //LOG IN AS ESS User
            logIn_Btn = driver.findElement(By.id("loginAsButtonGroup"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(logIn_Btn));
            logIn_Btn.click();
            //Existing users are: "ESS User", "1st Level Supervisor", "System Administrator", "Administrator
            userRole = logIn_Btn.findElement(By.xpath(".//*[.='ESS User']"));
            userRole.click();
            //VERIFY NEWLY CREATED ANNOUNCEMENT IS DISPLAYED IN NEWS TABLE
            WebElement newsTable = driver.findElement(By.id("newsOnDashboard"));
            explicitWait.until(ExpectedConditions.visibilityOf(newsTable));
            List<WebElement> newsData = newsTable.findElements(By.xpath(".//a[@class='truncate topic left-space']"));
            int newAnnouncementCount = 0;
            for (WebElement element: newsData){
                if (element.getText().equals(input_topic_text)) {
                    newAnnouncementCount++;
                    WebElement topic = element.findElement(By.xpath(".//ancestor::li//div[@class='truncate left-align']"));
                    Assert.assertEquals(element.getText(), input_topic_text);
                    Assert.assertEquals(topic.getText(), input_desc_text);
                    System.out.println("Topic and desc Verifies: " + newAnnouncementCount);
                }
            }
            //VERIFYING IF NEW ANNOUNCEMENT IS PRESENT
            Assert.assertTrue(newAnnouncementCount > 0);
            //LOG OUT
            userOptions = driver.findElement(By.id("account-job"));
            userOptions.click();
            logOut_Btn = driver.findElement(By.id("logoutLink"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(logOut_Btn));
            logOut_Btn.click();
            //LOG IN AS Administrator
            logIn_Btn = driver.findElement(By.id("loginAsButtonGroup"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(logIn_Btn));
            logIn_Btn.click();
            //Existing users are: "ESS User", "1st Level Supervisor", "System Administrator", "Administrator"
            userRole = logIn_Btn.findElement(By.xpath(".//*[.='Administrator']"));
            userRole.click();
            //CLICKING OPTIONS IN MENU BAR
            menuContent = driver.findElement(By.id("menu-content"));
            adminButton = menuContent.findElement(By.id("menu_admin_viewAdminModule"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(adminButton));
            adminButton.click();
            announcements = menuContent.findElement(By.id("menu_news_Announcements"));
            announcements.click();
            news = menuContent.findElement(By.id("menu_news_viewNewsList"));
            news.click();
            //SWITCHING TO IFRAME
            driver.switchTo().frame(mainFrame);
            //GETTING TABLE DATA ROWS AND SIZE
            tableRows = driver.findElements(By.className("dataRaw"));
            explicitWait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
            System.out.println(tableRows.size());
            for(WebElement element: tableRows){
                if (element.findElement(By.xpath(".//td[2]")).getText().equals(input_topic_text)){
                    System.out.println(element.findElement(By.xpath(".//td[2]")).getText());
                    WebElement deleteCheckBox = element.findElement(By.xpath(".//td[1]"));// DELETING DATA OF STUDENTS
                    deleteCheckBox.click();
                }
            }
            methods.sleep(2000);
            action.moveToElement(tableRows.get(0));
            //DELETING ANNOUNCEMENT
            WebElement tableOptions_Btn = driver.findElement(By.id("frmList_ohrmListComponent_Menu"));
            explicitWait.until(ExpectedConditions.visibilityOf(tableOptions_Btn));
            action.moveToElement(tableOptions_Btn).perform();
            tableOptions_Btn.click();
            WebElement deleteOption = driver.findElement(By.id("newsDelete"));
            deleteOption.click();
            WebElement deleteConfirmation = driver.findElement(By.id("news-delete-button"));
            explicitWait.until(ExpectedConditions.visibilityOf(deleteConfirmation));
            deleteConfirmation.click();
            //VERIFY DELETED ANNOUNCEMENT IS NOT PRESENT
            driver.navigate().refresh();
            driver.switchTo().frame(mainFrame);
            List<WebElement> tableRows1 = driver.findElements(By.className("dataRaw"));
            explicitWait.until(ExpectedConditions.visibilityOfAllElements(tableRows1));
            System.out.println(tableRows1.size());
            for(WebElement element: tableRows1){
                Assert.assertFalse(element.findElement(By.xpath(".//td[2]")).getText().equals(input_topic_text));
            }
            driver.close();
        }
    }

