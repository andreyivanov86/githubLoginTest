import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

        private WebDriver driver;
        private LogInPage logInPage;

        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "../driver/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            driver.get("https://github.com/login");
            logInPage = new LogInPage(driver);
        }

        @Test
        public void logInCredsErrorTest(){
            LogInPage newLogIn = logInPage.invalidCredentials("asds","asdfas");
            String error = newLogIn.getErrorText();
            Assert.assertEquals("Incorrect username or password.", error);
        }
        @Test
        public void createAccLinkTest() {
            SignUpPage createAcc = logInPage.createAccount();
            String header = createAcc.getHeaderText();
            Assert.assertEquals("Join GitHub", header);
        }

        @After
        public void tearDown() {
            driver.quit();
        }
}
