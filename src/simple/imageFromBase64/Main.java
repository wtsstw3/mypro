package simple.imageFromBase64;

import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static simple.imageFromBase64.CheckFileSequence.getAllFiles;

/**
 * Created by Black on 29.01.2019.
 */
public class Main {
    private static int i = 0;

    public static void main(String[] args) throws IOException {
        File[] allFiles = getAllFiles();
        for (File file : allFiles) {
            if(file.isFile()) {
                writeFile(file.getName());
            }
        }


        int j =0;
    }

    private static void writeFile(String name) throws IOException {

        String pageName = name.replaceAll(".txt","");
        int iter = Integer.parseInt(pageName.replaceAll("subcont",""));
        if((iter<680)) {
            return;
        }
        String s = readFile("C:\\Users\\Black\\Downloads\\1\\"+pageName+".txt", StandardCharsets.UTF_8);
        List<String> listOfBase64 = new ArrayList<>();
        for (String s1 : s.split(",data")) {
            s1 = s1.replaceAll("\\r\\n","");
            if(!s1.contains("data")) {
                s1 = "data"+s1;
            }
            listOfBase64.add(s1);
        }

        String path = "C:\\Users\\Black\\Downloads\\1\\pics1";
        new File(path).mkdirs();

        BASE64Decoder decoder = new BASE64Decoder();
        ByteArrayInputStream blackBis;

        BufferedImage result = new BufferedImage(
                1166, 1654, BufferedImage.TYPE_INT_RGB);
        Graphics g = result.getGraphics();
        int x = 0;
        int y = 0;


        for (String base64 : listOfBase64) {
            base64 = base64.replaceAll("data:image/png;base64,","");
            base64 = base64.replaceAll(":image/png;base64,","");
            byte[] imageByte = decoder.decodeBuffer(base64);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            BufferedImage image = ImageIO.read(bis);
            bis.close();

            g.drawImage(image, x, y, null);
            y += image.getHeight();
        }
        File outputfile = new File(path + "\\1image" + iter + ".png");
        ImageIO.write(result, "png", outputfile);
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


}
