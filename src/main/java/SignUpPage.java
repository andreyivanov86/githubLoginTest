import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Create account elements
    private By header = By.xpath("//*[@id=\"js-pjax-container\"]//h1[text()='Join GitHub']");
    private By userName = By.xpath("//*[@id=\"user_login\"]");
    private By userEmail = By.xpath("//*[@id=\"user_email\"]");
    private By userPassword = By.xpath("//*[@id=\"user_password\"]");
    private By createAccBtn = By.xpath("//*[@id=\"signup_button\"]");

    //Error elements
    private By mainTextErr = By.xpath("//*[@id=\"signup-form\"]/div[2]");
    private By userNameErr = By.xpath("//*[@id=\"signup-form\"]/dl[1]/dd[2]");
    private By userEmailErr = By.xpath("//*[@id=\"signup-form\"]/dl[2]/dd[2]");
    private By userPassErr = By.xpath("//*[@id=\"signup-form\"]/dl[3]/dd[2]");

    //Methods
    public SignUpPage typeUserName(String username) {
        driver.findElement(userName).sendKeys(username);
        return this;
    }
    public SignUpPage typeEmail(String useremail) {
        driver.findElement(userEmail).sendKeys(useremail);
        return this;
    }
    public SignUpPage typePass(String userpass) {
        driver.findElement(userPassword).sendKeys(userpass);
        return this;
    }

    //Executes above methods
    public SignUpPage registerInvalidCreds (String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePass(password);
        driver.findElement(createAccBtn);
        return new SignUpPage(driver);
    }

    //Check header text
    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    //Check errors text
    public String getMainErrorText() {
        return driver.findElement(mainTextErr).getText();
    }
    public String getUserNameErrText() {
        return driver.findElement(userNameErr).getText();
    }
    public String getEmailErrText() {
        return driver.findElement(userEmailErr).getText();
    }
    public String getPasswordErrText() {
        return driver.findElement(userPassErr).getText();
    }

}
