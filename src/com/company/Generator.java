package com.company;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Vasilii Minenko on 8/8/17.
 */
public class Generator {
    private static Integer FILE_COUNT_ROW = 1000;
    public static void main(String[] args) {
        String CSV = "id,rem,resC,sub,subD,selS,supP,supF,supT";
        for (int i = 1; i <= FILE_COUNT_ROW; i++) {
            CSV += "\n";
            Integer id = i;
            Integer rem = randInt(1,2000);
            Integer resC = randInt(1,2000);
            Integer sub = randInt(1,2000);
            Long subD = randLong(1501243355111L,1501243355777L);
            Integer selS = randInt(1, 100);
            String supP = String.format("%.2f",randDouble(0D, 50D));
            Long supF = randLong(1501243355111L,1501243355777L);
            Long supT = randLong(1501243355111L,1501243355777L);
            CSV += id + "," + rem + "," + resC + "," +sub + "," +subD + "," +selS + "," +supP + "," +supF + "," +supT;

        }

        writeToFile("/home/vm/Desktop/","CSV_"+FILE_COUNT_ROW, CSV);

        System.out.println(CSV);
    }

    private static void writeToFile(String filePath, String fileName, String line) {
        String updateLogsFolder = filePath;
        String name = fileName;
        try {
            File targetFile = new File(updateLogsFolder + name);
            File parent = targetFile.getParentFile();

            boolean bool = parent.mkdirs();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(updateLogsFolder + name))) {
                writer.write(line);
                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("Directory created? " + bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long randLong(Long rangeMin, Long rangeMax) {
        // Usually this can be a field rather than a method variable
        long generatedLong = rangeMin + (long) (Math.random() * (rangeMax - rangeMin));
        return generatedLong;
    }

    public static Double randDouble(Double rangeMin, Double rangeMax) {
        // Usually this can be a field rather than a method variable
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return randomValue;
    }


    public static int randInt(int rangeMin, int rangeMax) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;

        return randomNum;
    }



}


