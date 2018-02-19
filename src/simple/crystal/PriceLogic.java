package simple.crystal;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.apache.commons.collections4.keyvalue.MultiKey;

import java.util.*;

/**
 * Created by Black on 18.02.2018.
 */
public class PriceLogic {
    IntervalSolver intervalSolver = new IntervalSolver();
    List<Price> newPrices = new ArrayList<>();
    ListMultimap<MultiKey, DateValue> listMultimapPrices = ArrayListMultimap.create();

    public List<Price> merge(List<Price> prices) {
        prices.forEach(item -> processing(item));
        listMultimapPrices.keySet().forEach(item -> {
                    List<DateValue> mergeDateValues = intervalSolver.merge(listMultimapPrices.get(item));
                    mergeDateValues.forEach(dateValue -> {
                                Object[] keys = item.getKeys();
                                Price price = new Price((String) item.getKeys()[0], (int) item.getKeys()[1], (int) item.getKeys()[2], dateValue);
                                newPrices.add(price);
                            }
                    );
                }
        );
        return newPrices;
    }

    private void processing(Price item) {
        DateValue dateValue = new DateValue(item.getBegin(), item.getEnd(), item.getValue());
        addMultiKeyAndValue(item.getProduct_code(), item.getDepart(), item.getNumber(), dateValue);
    }

    private void addMultiKeyAndValue(Object key1, Object key2, Object key3, DateValue value) {
        MultiKey key = new MultiKey(key1, key2, key3);
        listMultimapPrices.put(key, value);
    }
}
