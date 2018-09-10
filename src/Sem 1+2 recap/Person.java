import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;



import static java.time.LocalDate.now;

public class Person{
    protected String name;
    protected String cpr;



    public Person(String name, String cpr) {
        this.name = name;
        this.cpr = cpr;
    }

    public Person(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    @Override
    public String toString(){
        return "{" + name + ", " + cpr + "}";
    }

    /**
     * This is a funktion for finding age from cpr
     * @return age
     */
    public int Age(){
        //Split the String
        String[] arr = cpr.split(" ");
        //Set up formatter for date to localDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        //Convert String to Date
        String date = arr[0];
        //Convert Date to localDate using the formatter
        LocalDate d = LocalDate.parse(date, formatter);
        //Test if it is after current date, if it is subtract 100 years from localDate
        if(d.isAfter(now())){
            d=d.minusYears(100);
        }
        //return the amount of years between the date and now
        return Period.between(d, now()).getYears();
    }


}
