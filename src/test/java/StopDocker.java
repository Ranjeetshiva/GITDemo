import org.testng.Assert;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class StopDocker {

    public void stopDockerFile() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start docketDown.bat");
        String file = "output.txt";
        boolean flag = false;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,15);
        long stopnow = calendar.getTimeInMillis();
        while (System.currentTimeMillis() < stopnow) {
            if(flag){
                break;
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                if (currentLine.contains("selenium-hub exited")) {
                    System.out.println("Shut Down Completed");
                    flag = true;
                    break;
                }
                currentLine = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        Assert.assertTrue(flag);
        Thread.sleep(10000);




    }
}
