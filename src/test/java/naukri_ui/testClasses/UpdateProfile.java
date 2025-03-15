package naukri_ui.testClasses;

import framework.init.WebDriverInit;
import naukri_ui.pageObjects.DashBoardPO;
import naukri_ui.pageObjects.LoginPO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static framework.utils.ExtentInit.testCaseLog;

public class UpdateProfile extends WebDriverInit {

    @Test
    @Parameters({"username" , "password"})
    public void updateProfileTest(String username , String password){
        testCaseLog("Updating the profile");
        new LoginPO(driver).loginAs(username , password);
        new DashBoardPO(driver).updateProfile();
    }
}
