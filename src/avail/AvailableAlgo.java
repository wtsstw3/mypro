package avail;

import avail.entity.Key;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AvailableAlgo {
    public static void main (String args []) {
        System. out. println ("Белые белые дни");
        Map<Key, String> map = new HashMap<Key, String>();
    }

    @SuppressWarnings("unchecked")
    public void parse(String fileName) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(
                    "/Users/<username>/Documents/file1.txt"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("Name");
            String author = (String) jsonObject.get("Author");
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");

            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}