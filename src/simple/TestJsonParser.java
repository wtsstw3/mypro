package simple;

import avail.entity.AvailableRow;
import avail.entity.Restriction;
import avail.entity.WearkLink;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Black on 26.09.2017.
 */
public class TestJsonParser {
    public static void main(String[] args) throws IOException, ParseException {
        String fileName = "C:\\work\\mine\\src\\simple\\testfiles\\Test.json";
        ArrayList<AvailableRow> availableTable = new ArrayList<>();
        Map<String, Long> wearksDeepthList = new HashMap<>();
        Map<String, ArrayList<WearkLink>> wearksLinksMap = new HashMap<>();
        TestJsonParser testJsonParser = new TestJsonParser();
        testJsonParser.parseTestJson(fileName, availableTable, wearksDeepthList, wearksLinksMap);
    }

    public void parseTestJson(String fileName, ArrayList<AvailableRow> availableTable,
                              Map<String, Long> wearksDeepthList,
                              Map<String, ArrayList<WearkLink>> wearksLinksMap) throws IOException, ParseException {
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
            ArrayList<Restriction> restrictions = new ArrayList<>();
            JSONArray restrictionsJSON = (JSONArray) ((JSONObject) item).get("Restrictions");
            restrictionsJSON.forEach(restriction -> {
                String type = (String) ((JSONObject) item).get("Type");
                Long id = (Long) ((JSONObject) item).get("Id");
                restrictions.add(new Restriction(type, id));
            });
            if(wearksLinksMap.get(firstWeark)!= null) {
                wearksLinksMap.get(firstWeark).add(new WearkLink(secondWeark, restrictions));
            } else {
                ArrayList<WearkLink> linksArray = new ArrayList<>();
                linksArray.add(new WearkLink(secondWeark, restrictions));
                wearksLinksMap.put(firstWeark, linksArray);
            }
        });
    }

}
