package simple.imageFromBase64;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Black on 30.01.2019.
 */
public class CheckFileSequence {
    public static void main(String[] args) throws Exception {
        File[] listOfFiles = getAllFiles();
        for (File file : listOfFiles) {
            if(file.getName().contains("(")) {
                file.delete();
            }
        }
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < 704; i++) {
            list.add(i);
        }
        for (int i = 0; i < 704; i++) {
            for (File listOfFile : listOfFiles) {
                if(listOfFile.getName().equals("subcont"+i+".txt")) {
                    list.remove(i);
                }
            }
        }
        if(list.size()>1) {
            throw new Exception("AAAAAAAAAAA");
        }
        int i = 0;
    }

    static File[] getAllFiles() {
        File folder = new File("C:\\Users\\Black\\Downloads\\1\\");
        return folder.listFiles();
    }
}