import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Student {
    public static void main(String[] args) {
        String x = "2020-12-12";
        String y = "2020-06-12";
        LocalDate x1 = LocalDate.parse(x);
        LocalDate y1 = LocalDate.parse(y);
        Period z= Period.between(y1,x1);
        System.out.println(z.getMonths());
    }
}
