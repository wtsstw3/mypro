package avail.entity;

import java.util.ArrayList;

/**
 * Created by Black on 26.09.2017.
 */
public class WearkLink {

    ArrayList<Restriction> restrictions;
    String targetWeark;

    public WearkLink(String targetWeark,ArrayList<Restriction> restrictions) {
        this.restrictions = restrictions;
        this.targetWeark = targetWeark;
    }

    public ArrayList<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

    public String getTargetWeark() {
        return targetWeark;
    }

    public void setTargetWeark(String targetWeark) {
        this.targetWeark = targetWeark;
    }

}
