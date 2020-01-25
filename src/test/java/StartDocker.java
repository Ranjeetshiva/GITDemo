import org.testng.Assert;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class StartDocker {

    public void startDockerFile() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start docketUp.bat");
        String file = "output.txt";
        boolean flag = false;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,15);
        long stopnow = calendar.getTimeInMillis();
        while (System.currentTimeMillis() < stopnow) {
            if(flag){
                break;
            }
            File tempFile = new File("file");
            if(!tempFile.exists()){
                Thread.sleep(3000);
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                if (currentLine.contains("The node is registered to the hub and ready to use")) {
                    System.out.println("Found My Text");
                    flag = true;
                    break;
                }
                currentLine = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        Assert.assertTrue(flag);
        runtime.exec("cmd /c start scale.bat");



    }
}
