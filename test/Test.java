import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;
import simple.crystal.DateValue;
import simple.crystal.IntervalSolver;
import simple.crystal.PriceLogic;
import simple.crystal.Price;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 18.02.2018.
 */
@ContextConfiguration
public class Test {
    PriceLogic priceLogic = new PriceLogic();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
    ArrayList<Price> prices = new ArrayList<>();
    ArrayList<DateValue> dateValues = new ArrayList<>();
    ArrayList<Price> initialPrices = new ArrayList<>();
    ArrayList<DateValue> initialDateValues = new ArrayList<>();
    IntervalSolver intervalSolver = new IntervalSolver();


    @org.junit.Test
    public void mergeDateValueTest() throws Exception {
        initialData();
        setDateValue("01-01-2017","03-01-2017",5000,true);
        setDateValue("03-01-2017","05-01-2017",5000,true);
        setDateValue("08-01-2017","09-01-2017",5000,true);
        setDateValue("12-01-2017","15-01-2017",5000,true);
        setDateValue("16-01-2017","19-01-2017",5000,true);
        setDateValue("22-01-2017","28-01-2017",5000,true);

        Assert.isTrue(intervalSolver.checkInitialInterval(initialDateValues),"Ihe initial data is incorrect");
        Assert.isTrue(intervalSolver.checkInitialInterval(dateValues),"The new data is incorrect");

        dateValues.addAll(initialDateValues);

        List<DateValue> newPrices = intervalSolver.merge(dateValues);
        newPrices.forEach(item -> System.out.println(item.toString()));
    }

    @org.junit.Test
    public void mergePricesTest() throws Exception {

        setInitialPrice("1",1,1,"15-01-2017","18-01-2017",500);
        setInitialPrice("1",1,1,"02-01-2017","06-01-2017",500);
        setInitialPrice("1",1,1,"08-01-2017","10-01-2017",500);
        setInitialPrice("1",1,1,"01-01-2017","03-01-2017",5000);
        setInitialPrice("2",1,1,"01-01-2017","03-01-2017",5000);

        List<Price> newPrices = priceLogic.merge(prices);
        Assert.isTrue(newPrices.size()==5,"This test failed validation\n");
        newPrices.forEach(item -> System.out.println(item.toString()));
    }


    private void initialData() throws ParseException {
        setInitialDateValue("01-01-2017","03-01-2017",500, false);
        setInitialDateValue("03-01-2017","06-01-2017",500,false);
        setInitialDateValue("07-01-2017","10-01-2017",500,false);
        setInitialDateValue("14-01-2017","17-01-2017",500, false);
        setInitialDateValue("17-01-2017","20-01-2017",500,false);
        setInitialDateValue("21-01-2017","23-01-2017",500,false);
        setInitialDateValue("25-01-2017","26-01-2017",500,false);

    }

    private void setDateValue(String date1, String date2, long value, boolean isNew) throws ParseException {
        DateValue dateValue1 = new DateValue(sdf.parse(date1), sdf.parse(date2), value, isNew);
        dateValues.add(dateValue1);
    }

    private void setInitialDateValue(String date1, String date2, long value, boolean isNew) throws ParseException {
        DateValue dateValue1 = new DateValue(sdf.parse(date1), sdf.parse(date2), value, isNew);
        initialDateValues.add(dateValue1);
    }


    private void setInitialPrice(String product_code, int number, int depart, String date1, String date2, long value) throws ParseException {
        DateValue dateValue1 = new DateValue(sdf.parse(date1), sdf.parse(date2), value);
        Price price1 = new Price(product_code, number, depart, dateValue1);
        prices.add(price1);
    }


    private void setPrice(String product_code, int number, int depart, String date1, String date2, long value) throws ParseException {
        DateValue dateValue1 = new DateValue(sdf.parse(date1), sdf.parse(date2), value);
        Price price1 = new Price(product_code, number, depart, dateValue1);
        prices.add(price1);
    }

}
