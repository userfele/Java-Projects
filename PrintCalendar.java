import java.time.LocalDate;
import java.util.Scanner;

public class PrintCalendar {

    static final int width = 20;
    static final int week = 7;

    public static void main(String[] args) {
        PrintCalendar pc = new PrintCalendar();
        pc.printCalendar();
    }

    public void printCalendar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Must be 1-12.");
            return;
        }

        printHeader(month, year);

        int weekdayValue = getDayOfWeek(year, month, 1);
        int weekday = weekdayValue % week;
        int daysInMonth = getLengthOfMonth(year, month, 1);

        int currentDay = 1;

        while (currentDay <= daysInMonth) {
            currentDay = printWeek(currentDay, weekday, daysInMonth);
            weekday = 0;
        }
    }

    public void printHeader(int mo, int yr) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        String title = months[mo - 1] + " " + yr;
        int leadSpaces = (width - title.length()) / 2;

        System.out.println();
        System.out.println(spaces(leadSpaces) + title);
        System.out.println("Su Mo Tu We Th Fr Sa");
    }

    public String spaces(int numSpaces) {
        String s = "";
        for (int i = 0; i < numSpaces; i++) {
            s += " ";
        }
        return s;
    }

    public int getDayOfWeek(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().getValue();
    }

    public int getLengthOfMonth(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.lengthOfMonth();
    }

    public int printWeek(int dayNumber, int weekday, int daysInMonth) {
        weekday = weekday % week;

        System.out.print(spaces(weekday * 3));

        while (weekday <= 6 && dayNumber <= daysInMonth) {
            System.out.print(String.format("%2d ", dayNumber));
            weekday++;
            dayNumber++;
        }

        System.out.println();
        return dayNumber;
    }
}