package calendar;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter year (e.g., 2025): ");
        int year = scanner.nextInt();

        System.out.println("Enter month (1-12): ");
        int month = scanner.nextInt() - 1;

        printCalendar(year, month);

        scanner.close();
    }

    public static void printCalendar(int year, int month) {
        String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        Calendar cal = new GregorianCalendar(year, month, 1);

        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("\nCalendar for " + (month + 1) + "/" + year);
        for (String day : days) {
            System.out.print(day + "\t");
        }
        System.out.println();

        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("\t");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.print(day + "\t");
            if ((day + firstDayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

