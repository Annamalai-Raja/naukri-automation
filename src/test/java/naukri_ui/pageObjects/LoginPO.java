package naukri_ui.pageObjects;

import framework.init.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.utils.TestLogger.testInfoLog;
import static framework.utils.TestLogger.testStepsLog;

public class LoginPO extends AbstractClass {

    @FindBy(id = "login_Layer")
    public WebElement btnLoginNavigation;

    @FindBy(xpath = "//input[contains(@placeholder , ' Username')]")
    public  WebElement txtUsername;

    @FindBy(xpath = "//input[contains(@placeholder , ' password')]")
    public  WebElement txtPassword;

    @FindBy(xpath = "//button[text() = 'Login']")
    public  WebElement btnLogin;

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public void loginAs(String username , String password){
        testStepsLog("Click on the Login Navigation Button");
        clickByElement(driver , btnLoginNavigation);
        testInfoLog("Enter Username as : " + username);
        sendKeys(txtUsername , username);
        testInfoLog("Enter password as : " + password);
        sendKeys(txtPassword , password);
        testStepsLog("Click on Login button");
        clickByElement(driver , btnLogin );
    }




}
