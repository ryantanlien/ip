import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeManager {
    public static String toLocalDateTime(String dateTime) {
        String[] dateThenTime = dateTime.split(" ");
        String date = dateThenTime[0];
        String time = dateThenTime[1];
        try {
            LocalDate localDate = LocalDate.parse(date);
            LocalTime localTime = LocalTime.parse(time);
            String newLocalDate = localDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            String newLocalTime = localTime.format(DateTimeFormatter.ofPattern("Hm"));
            if (newLocalTime.length() == 3) {
                newLocalTime = "0" + newLocalTime;
            }
            return newLocalDate.toString() + " " + newLocalTime.toString();
        } catch (DateTimeException exception) {
            System.out.println("Input date followed by time");
            System.out.println("Date must be in the format: YY-MM-DD");
            System.out.println("Time must be in the format: hh:mm:ss\n");
        }
        return "";
    }
}
