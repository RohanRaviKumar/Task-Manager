package TaskManagerApplication;

import java.time.LocalDate;
import java.time.Period;

public class TimeRemainingToCompleteTask {
    public int noOfDays(String inputDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = LocalDate.parse(inputDate);
        Period period = Period.between(currentDate, futureDate);
        int days = (period.getYears() * 365) + (period.getMonths() * 30) + period.getDays();
        return days;
    }
}

