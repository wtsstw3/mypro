package simple.crystal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Black on 18.02.2018.
 */
public class Price {

    public Price(String product_code, int number, int depart, Date begin, Date end, long value) {
        this.product_code = product_code;
        this.number = number;
        this.depart = depart;
        this.begin = begin;
        this.end = end;
        this.value = value;
    }

    public Price(String product_code, int number, int depart, DateValue dateValue) {
        this.product_code = product_code;
        this.number = number;
        this.depart = depart;
        this.begin = dateValue.getBeginDate();
        this.end = dateValue.getEndDate();
        this.value = dateValue.getValue();
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    String product_code;
    int number;
    int depart;
    Date begin;
    Date end;
    long value;

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Price{" +
                ", product='" + product_code + '\'' +
                ", depart=" + depart +
                ", number=" + number +
                ", value=" + value +
                ", beginDate=" + formatter.format(begin) +
                ", endDate=" + formatter.format(end) +
                '}';
    }
}
