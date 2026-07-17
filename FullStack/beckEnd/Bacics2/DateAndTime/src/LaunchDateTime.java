import java.time.*;


public class LaunchDateTime {
    public static void main(String[] args) throws Exception {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
    }
}
