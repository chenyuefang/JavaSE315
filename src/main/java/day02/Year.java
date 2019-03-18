package day02;

import java.util.Scanner;

public class Year {
    public boolean isLeapYear(int year) {
        return year % 4 == 0 || (year % 400 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input year: ");

        int year = scanner.nextInt();

        Year year1=new Year();

        System.out.println(year + " is leap year: " + year1.isLeapYear(year));
    }
}

