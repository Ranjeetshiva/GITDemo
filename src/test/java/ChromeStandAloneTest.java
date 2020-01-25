import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ChromeStandAloneTest {

    public static void main(String[] args) throws MalformedURLException {

        //Remote WebDriver
        URL url=new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities=  DesiredCapabilities.chrome();
        RemoteWebDriver remoteWebDriver=new RemoteWebDriver(url, capabilities);

        remoteWebDriver.navigate().to("https://www.google.com/");

        System.out.println(capabilities.getBrowserName());

        System.out.println(remoteWebDriver.getTitle());





    }


}
