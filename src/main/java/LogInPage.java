import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userName = By.xpath("//*[@id=\"login_field\"]");
    private By passWord = By.xpath("//*[@id=\"password\"]");
    private By signInBtn = By.xpath("//*[@id=\"login\"]/form/div[4]/input[3]");
    private By header = By.xpath("//h1[text()='Sign in to GitHub']");
    private By error = By.xpath("//*[@id=\"js-flash-container\"]/div/div");
    private By createAccLink = By.xpath("//*[@id=\"login\"]/p/a");


    public LogInPage typeUserName(String username) {
        driver.findElement(userName).sendKeys(username);
        return this;
    }

    public LogInPage typePassword(String password) {
        driver.findElement(passWord).sendKeys(password);
        return this;
    }

    public LogInPage invalidCredentials(String username, String password) {
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signInBtn).click();
        return new LogInPage(driver);
    }
    public String getHeadingText(){
        return driver.findElement(header).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }
}
