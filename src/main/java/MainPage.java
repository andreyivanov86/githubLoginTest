import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Element locators
    private By signInLink = By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[1]");
    private By signUpLink = By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[2]");
    private By inputUsrName = By.xpath("//*[@id=\"user[login]\"]");
    private By inputEmail = By.xpath("//*[@id=\"user[email]\"]");
    private By inputPass = By.xpath("//*[@id=\"user[password]\"]");
    private By signUpBtn = By.xpath("//button[text()='Sign up for GitHub']");

    //Methods
    public LogInPage clickSignInLink(){
        driver.findElement(signInLink).click();
        return new LogInPage(driver);
    }
    public SignUpPage clickSignUpLink(){
        driver.findElement(signUpLink).click();
        return new SignUpPage(driver);
    }
    public SignUpPage clickSignUpBtn(){
        driver.findElement(signUpBtn).click();
        return new SignUpPage(driver);
    }
    public MainPage typeUserName(String userName) {
        driver.findElement(inputUsrName).sendKeys(userName);
        return this;
    }
    public MainPage typeEmail(String userEmail) {
        driver.findElement(inputEmail).sendKeys(userEmail);
        return this;
    }
    public MainPage typePass(String userPass) {
        driver.findElement(inputPass).sendKeys(userPass);
        return this;
    }
    // Methods call
    public SignUpPage register(String userName, String email, String password) {
        this.typeUserName(userName);
        this.typeEmail(email);
        this.typePass(password);
        this.clickSignUpBtn();
        return new SignUpPage(driver);
    }

}
