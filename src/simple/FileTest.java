package simple;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public void runCreateFileTest (){
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String updateLogsFolder = "/home/vm/work/photo_log/";
        String name = formatForDateNow.format(date);
        try {
            File targetFile = new File(updateLogsFolder + name);
            File parent = targetFile.getParentFile();

            boolean bool = parent.mkdirs();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(updateLogsFolder + name))) {

                String content = "This is the content to write into file\n";

                writer.write(content);
                writer.write(content);
                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("Directory created? " + bool);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
