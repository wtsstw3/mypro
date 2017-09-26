package avail;

import avail.entity.AvailableRow;
import avail.entity.DeliveryRow;
import avail.entity.ResultAvailableRow;
import avail.entity.WearkInfoRow;
import org.json.simple.parser.ParseException;
import simple.TestJsonParser;

import java.io.IOException;
import java.util.*;

public class AvailableAlgo {
    public static void main(String args[]) throws IOException, ParseException {
        final String dir = System.getProperty("user.dir");
        String fileName = "src/simple/testfiles/Test.json";
        ArrayList<AvailableRow> availableTable = new ArrayList<>();
        ArrayList<DeliveryRow> deliveryTable = new ArrayList<>();
        ArrayList<ResultAvailableRow> resultAvailableTable = new ArrayList<>();
        Map<String, Long> wearksDeepthList = new HashMap<>();
        Map<String, ArrayList<WearkInfoRow>> wearksLinksMap = new HashMap<>();
        TestJsonParser testJsonParser = new TestJsonParser();
        testJsonParser.parseTestJson(fileName, availableTable, wearksDeepthList, wearksLinksMap);
        availableTable.forEach(item -> {
            Set<String> wearksList = new HashSet<>();
            String currentWeark = item.getShopId();
            Long depth = wearksDeepthList.get(currentWeark);
            if (depth == null) {
                depth = 3L;
            }
            getChildsForWeark(depth, item.getSapGoodId(), item.getSapMaterialTypeId(), currentWeark, wearksList, wearksLinksMap);
            wearksList.remove(currentWeark);
            System.out.println(wearksList);
            DeliveryRow wearkInfoRow = new DeliveryRow(item.getShopId(), item.getGoodId(), wearksList, wearksList);
            deliveryTable.add(wearkInfoRow);
            for (String weark : wearksList) {
                ResultAvailableRow resultAvailableRow = new ResultAvailableRow(weark, item.getGoodId(), 0L, item.getReserveCount(), item.getAvailableCount());
                resultAvailableTable.add(resultAvailableRow);
            }


        });
    }


    public static void getChildsForWeark(Long depth, Long currentMaterialId, Long currentMaterialType, String currentWeark, Set<String> wearksList, Map<String, ArrayList<WearkInfoRow>> wearksLinksMap) {
        wearksList.add(currentWeark);
        if (depth > 1 && wearksLinksMap.get(currentWeark) != null) {
            wearksLinksMap.get(currentWeark).forEach(item -> {
                System.out.println(currentWeark + "->" + item.getTargetWeark());
                Map<String, Set<Long>> restrictions = item.getRestrictions();
                Set<Long> materialRestrictions = restrictions.get("M");
                Set<Long> typeRestrictions = restrictions.get("G");
                if (materialRestrictions.contains(currentMaterialId) || typeRestrictions.contains(currentMaterialType)) {
                    return;
                } else {
                    wearksList.add(item.getTargetWeark());
                    getChildsForWeark(depth - 1, currentMaterialId, currentMaterialType, item.getTargetWeark(), wearksList, wearksLinksMap);
                }
            });
        }
        return;
    }
}