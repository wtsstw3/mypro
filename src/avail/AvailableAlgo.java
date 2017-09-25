package avail;

import avail.entity.AvailableRow;
import avail.entity.WearkLink;
import org.json.simple.parser.ParseException;
import simple.TestJsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AvailableAlgo {
    public static void main(String args[]) throws IOException, ParseException {
        String fileName = "C:\\work\\mine\\src\\simple\\testfiles\\Test.json";
        ArrayList<AvailableRow> availableTable = new ArrayList<>();
        Map<String, Long> wearksDeepthList = new HashMap<>();
        Map<String, ArrayList<WearkLink>> wearksLinksMap = new HashMap<>();
        TestJsonParser testJsonParser = new TestJsonParser();
        testJsonParser.parseTestJson(fileName, availableTable, wearksDeepthList, wearksLinksMap);
        int a = 1;
        availableTable.forEach(item -> {
            String currentWeark = item.getWeark();
            Long depth = wearksDeepthList.get(currentWeark);
            while (depth>0) {
                //Here could be your recursion
                //wearksLinksMap.get(currentWeark);
                depth--;
            }
        });

    }

}