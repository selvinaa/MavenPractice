import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenPractice {
    public static void main(String[] args) {
       // WebDriverManager.chromedriver().setup();// this is instead of using system
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://google.com");
        TestData test = new TestData();// our constructor calling all methods form TestData class

        System.out.println(test.getRandomFirstName());
        System.out.println(test.getRandomLastName());
        System.out.println(test.getRandomPhoneNum());
        System.out.println(test.getRandomAddress());

    }
}
