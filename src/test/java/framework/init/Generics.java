package framework.init;

import framework.utils.Configuration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Generics implements Configuration {

    public static WebDriverWait WAIT;

    public void openUrl(WebDriver driver , String url){
        driver.get(url);
    }


    public void implicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
    }


    public void maximizeWindow(WebDriver driver){
        driver.manage().window().maximize();
    }

    public void clickByElement(WebDriver driver, WebElement element){
        element.click();
    }

    public void sendKeys(WebElement element , String string){
        element.sendKeys(string);
    }

    public void clearField(WebElement element){
        element.clear();
    }

    public void clickByElementJS(WebDriver driver , WebElement element){
        JavascriptExecutor js_executor = (JavascriptExecutor) driver;
        js_executor.executeScript("arguments[0].click();" , element);
    }

    public void deleteCookies(WebDriver driver){
        driver.manage().deleteAllCookies();
    }

    public void quit(WebDriver driver){
        driver.quit();
    }

    public String fetchNumbers(String input) {
        Pattern pattern = Pattern.compile("over ([\\d,]+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1).replace(",", "");
        } else {
            return "0";
        }
    }

    public void clearByBackSpace(WebElement element) {
      element.sendKeys(Keys.CONTROL + "a");
      element.sendKeys(Keys.BACK_SPACE);
    }


}
