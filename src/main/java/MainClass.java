import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/andreyi/Documents/JavaAutomation/driver/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //////////////
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        mainPage.register("tester", "tester@tester.com", "testtest" );

       driver.quit();
    }
}
