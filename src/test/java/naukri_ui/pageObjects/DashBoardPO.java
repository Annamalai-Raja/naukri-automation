package naukri_ui.pageObjects;

import framework.init.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.utils.TestLogger.testStepsLog;

public class DashBoardPO extends AbstractClass {

    @FindBy(className =  "nI-gNb-drawer__bars")
    public WebElement btnMenuBar;

    @FindBy(xpath =  "//a[contains(text() , 'View & Update Profile')]")
    public WebElement btnViewProfile;

    @FindBy(xpath  ="//em[@class=\"icon edit \"]")
    public WebElement btnEditIcon;

    @FindBy(xpath  ="//input[@placeholder=\"Enter Your Name\"]")
    public WebElement txtProfileName;

    @FindBy(id="saveBasicDetailsBtn")
    public WebElement btnSave;

    public  DashBoardPO(WebDriver driver){
        super(driver);
    }


    public void updateProfile(){
        testStepsLog("Click on Menu Bar");
        clickByElement(driver , btnMenuBar);
        testStepsLog("Click on View Profile Button");
        clickByElement(driver , btnViewProfile);
        testStepsLog("Click on Edit Icon");
        clickByElement(driver , btnEditIcon);
        testStepsLog("Click on Update Details and Save");
        clearByBackSpace(txtProfileName);
        sendKeys(txtProfileName , "Annamalai R");
        clickByElement(driver , btnSave);
    }

}
