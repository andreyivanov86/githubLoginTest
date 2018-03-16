import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "../driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void singUpInvalidUserTest() {
        SignUpPage signUp = signUpPage.typeUserName("andrey");
        String error = signUp.getUserNameErrText();
        Assert.assertEquals("Username is already taken", error);
    }

    @Test
    public void singUpUserNameTakenTest() {
        SignUpPage signUp = signUpPage.typeUserName("username");
        String error = signUp.getUserNameErrText();
        Assert.assertEquals("Username name 'username' is a reserved word", error);
    }

    @Test
    public void singUpInvalidPasswordTest() {
        SignUpPage singUp = signUpPage.typePass("asdfas");
        String error = singUp.getPasswordErrText();
        Assert.assertEquals("Password is too short (minimum is 7 characters) and needs at least one number", error);
    }

    @Test
    public void JoinHeaderTest() {
        String header = signUpPage.getHeaderText();
        Assert.assertEquals("Join GitHub", header);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
