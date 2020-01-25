import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest1 {

    @BeforeTest
    public void startDocker() throws IOException, InterruptedException {
        File tempFile = new File("output.txt");
        if( tempFile.delete()){
            System.out.println("output file deleted");
        }
        StartDocker startDocker=new StartDocker();
        startDocker.startDockerFile();
    }

    @AfterTest
    public void stopDocker() throws IOException, InterruptedException {
        StopDocker stopDocker=new StopDocker();
        stopDocker.stopDockerFile();
    }

    @Test
    public void Test1() throws MalformedURLException {

        URL  url = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities=  DesiredCapabilities.chrome();
        RemoteWebDriver remoteWebDriver=new RemoteWebDriver(url, capabilities);

        remoteWebDriver.navigate().to("https://www.google.com/");

        System.out.println(capabilities.getBrowserName());

        System.out.println(remoteWebDriver.getTitle());

    }
}
