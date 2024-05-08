import java.time.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your BirthDate in this Format YYYY-MM-DD: ");
        String InputDate = sc.nextLine();

        String[] Date = InputDate.split("-");
        

        LocalDate BirthDate = LocalDate.of(Integer.parseInt(Date[0]), Integer.parseInt(Date[1]), Integer.parseInt(Date[2]));

        LocalDate CurrentDate = LocalDate.now();

        Period period = Period.between(BirthDate, CurrentDate);

        int years = period.getYears();
        int month = period.getMonths();
        int days = period.getDays();
        System.out.println("Your Age is: " + years + " years, "+ month + " months, "+days + " days");
        sc.close();
    }
}