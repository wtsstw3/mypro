package simple;

import avail.entity.AvailableRow;
import avail.entity.WearkInfoRow;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Black on 26.09.2017.
 */
public class TestJsonParser {
    public static void main(String[] args) throws IOException, ParseException {
        String fileName = "C:\\work\\mine\\src\\simple\\testfiles\\Test.json";
        ArrayList<AvailableRow> availableTable = new ArrayList<>();
        Map<String, Long> wearksDeepthList = new HashMap<>();
        Map<String, ArrayList<WearkInfoRow>> wearksLinksMap = new HashMap<>();
        TestJsonParser testJsonParser = new TestJsonParser();
        testJsonParser.parseTestJson(fileName, availableTable, wearksDeepthList, wearksLinksMap);
    }

    public void parseTestJson(String fileName, ArrayList<AvailableRow> availableTable,
                              Map<String, Long> wearksDeepthList,
                              Map<String, ArrayList<WearkInfoRow>> wearksLinksMap) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        JSONObject json = (JSONObject) jsonParser.parse(new FileReader(fileName));

        ((JSONArray) json.get("WearksDepth")).forEach(item -> {
            String wearkName = (String) ((JSONObject) item).get("Weark");
            Long wearkDeep = (Long) ((JSONObject) item).get("Deep");
            wearksDeepthList.put(wearkName, wearkDeep);
        });

        ((JSONArray) json.get("WearksStocks")).forEach(item -> {
            String weark = (String) ((JSONObject) item).get("Weark");
            ;
            Long materialId = (Long) ((JSONObject) item).get("Material");
            Long siteMaterialId = (Long) ((JSONObject) item).get("SiteMaterial");
            Long materialTypeId = (Long) ((JSONObject) item).get("MaterialType");
            Long available = (Long) ((JSONObject) item).get("Available");
            Long reserve = (Long) ((JSONObject) item).get("Reserve");
            availableTable.add(new AvailableRow(weark, materialId, siteMaterialId, materialTypeId, available, reserve));
        });

        ((JSONArray) json.get("WearksGraph")).forEach(item -> {
            String firstWeark = (String) ((JSONObject) item).get("FirstWeark");
            String secondWeark = (String) ((JSONObject) item).get("SecondWeark");
            Map<String, Set<Long>> restrictions = new HashMap<>();
            JSONArray restrictionsJSON = (JSONArray) ((JSONObject) item).get("Restrictions");
            restrictionsJSON.forEach(restriction -> {
                String type = (String) ((JSONObject) restriction).get("Type");
                ArrayList<Long> ids = (JSONArray) ((JSONObject) restriction).get("Value");
                restrictions.put(type,new HashSet<>(ids));
            });
            if(wearksLinksMap.get(firstWeark)!= null) {
                wearksLinksMap.get(firstWeark).add(new WearkInfoRow(secondWeark, restrictions));
            } else {
                ArrayList<WearkInfoRow> linksArray = new ArrayList<>();
                linksArray.add(new WearkInfoRow(secondWeark, restrictions));
                wearksLinksMap.put(firstWeark, linksArray);
            }
        });
    }

}
