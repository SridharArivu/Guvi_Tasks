package task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long Number = sc.nextInt();
        long ReversedNumber  = 0;
        while(Number != 0){
            long lastDigit = Number % 10;
            ReversedNumber = (ReversedNumber * 10) + lastDigit;
            Number = Number/10;
        }
        System.out.println(ReversedNumber);
    }
}
