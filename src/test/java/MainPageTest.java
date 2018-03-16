import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "../driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void singInTest(){
        LogInPage logInPage = mainPage.clickSignInLink();
        String header = logInPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", header);
    }
    @Test
    public void registerFailTest(){
        SignUpPage singUpPage = mainPage.register("andreyTest", "andreytest@gtest.com", "12345");
        String error = singUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }
    @Test
    public void singUpEmptyUserNameTest(){
        SignUpPage signUpPage = mainPage.register("", "andreytest@gtest.com", "12345");
        String error = signUpPage.getUserNameErrText();
        Assert.assertEquals("Login can't be blank", error);
    }
    @Test
    public void invalidEmailFormatTest() {
        SignUpPage singUpPage = mainPage.register("andreytest", "adfasdf", "asdfasdf");
        String error = singUpPage.getEmailErrText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
