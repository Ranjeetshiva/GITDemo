import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest2 {
    @Test
    public void Test2() throws MalformedURLException {
       
        //Remote WebDriver
        URL url=new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities =  DesiredCapabilities.chrome();


        RemoteWebDriver remoteWebDriver=new RemoteWebDriver(url, capabilities);

        remoteWebDriver.navigate().to("https://www.gmail.com");

        System.out.println(capabilities.getBrowserName());

        System.out.println(remoteWebDriver.getTitle());

    }
}
