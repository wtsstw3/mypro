package simple.crystal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Black on 18.02.2018.
 */
public class DateValue {

    private Date beginDate;
    private Date endDate;
    private long value;
    private boolean isNew = true;

    public DateValue(Date beginDate, Date endDate, long value) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.value = value;
    }

    public DateValue(Date beginDate, Date endDate, long value, boolean isNew) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.value = value;
        this.isNew = isNew;
    }


    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }



    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "DateValue{" +
                "beginDate=" + formatter.format(beginDate) +
                ", endDate=" + formatter.format(endDate) +
                ", value=" + value +
                ", isNew=" + isNew() +
                '}';
    }

}
