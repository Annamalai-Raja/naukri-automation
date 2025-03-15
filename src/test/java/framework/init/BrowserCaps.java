package framework.init;

import framework.utils.Configuration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserCaps implements Configuration {
    public static String osName = "";
    public static String browserVersion = "";
    public static String browserName = "";

   static DesiredCapabilities configureGridBrowser(){
       DesiredCapabilities caps = new DesiredCapabilities();
       caps.setCapability(CapabilityType.PLATFORM_NAME , Platform.MAC);
       caps.setCapability(CapabilityType.BROWSER_NAME , BROWSER);

       osName = System.getProperty("os.name");
       browserName = caps.getBrowserName();
       browserVersion = caps.getBrowserVersion();

       System.out.println("OS Name :"  + osName);
       System.out.println("Browser Name :"  + browserName);
       System.out.println("Browser Version :"  + browserVersion);

       return caps;
    }

    static DesiredCapabilities configureCloudBrowser(String suiteName){
       DesiredCapabilities caps = new DesiredCapabilities();
       caps.setPlatform(Platform.WIN11);
       caps.setBrowserName(BROWSER);

        Map<String , Object>  ltOptions = new HashMap<>();
        ltOptions.put("username" , System.getenv("LT_UN"));
        ltOptions.put("accessKey" , System.getenv("LT_AK"));
        ltOptions.put("build"  , "BUILD - " + suiteName+ " Test");
        ltOptions.put("name" , suiteName );
        ltOptions.put("video" , true);
        ltOptions.put("screenshot" , true);
        ltOptions.put("logs" , true);
        ltOptions.put("console" , true);

        caps.setCapability("LT:Options" , ltOptions);
        return caps;
    }

    static URL getGridUrl() {
        try {
            return new URL("http://"+SELENIUM_HUB+":"+SELENIUM_PORT);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL", e);
        }
    }

    static URL getRemoteURl(){

        try {
            return  new URL("https://hub.lambdatest.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Remote URl");
        }
    }


}
