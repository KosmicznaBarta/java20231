import java.util.Scanner;
public class LeapYear {
    public static boolean isLeapYear(int year)
    {
        if (year >= 1 && year <= 9999)
        {
            if (year % 4 == 0)
            {
                if (year % 100 == 0)
                {
                    if (year % 400 == 0)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

public static void main(String[] args)
{
    Scanner scan = new Scanner(System.in);
    System.out.print("Write your example of a year and check, if it's a leap year: ");
    int year = scan.nextInt();
    scan.close();

    boolean isLeap = isLeapYear(year);

    if (isLeap)
    {
        System.out.println(year + " is a leap year");
    }
    else
    {
        System.out.println(year + " is not a leap year");
    }
}
}
