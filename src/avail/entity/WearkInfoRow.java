package avail.entity;

import java.util.Map;
import java.util.Set;

/**
 * Created by Black on 26.09.2017.
 */
public class WearkInfoRow {

    private String targetWeark;
    private Map<String, Set<Long>> restrictions;

    public String getTargetWeark() {
        return targetWeark;
    }

    public void setTargetWeark(String targetWeark) {
        this.targetWeark = targetWeark;
    }

    public Map<String, Set<Long>> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Map<String, Set<Long>> restrictions) {
        this.restrictions = restrictions;
    }

    public WearkInfoRow(String targetWeark, Map<String, Set<Long>> restrictions) {
        this.restrictions = restrictions;
        this.targetWeark = targetWeark;
    }


}
