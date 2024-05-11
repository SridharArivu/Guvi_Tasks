package task5;

import java.util.Scanner;

public class Main {
    public static int discount(double amount, int percentage){
        return (int) (amount - (amount / 100) * percentage);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextInt();

        if(amount < 500){
            System.out.println("no discount is applied, final payable amount is Rs."+discount(amount,0));
        } else if (amount <= 1000) {
            System.out.println("10% discount is applied, final payable amount is Rs." +  discount(amount,10));
        }else {
            System.out.println("20% discount is applied, final payable amount is Rs."+ discount(amount,20));
        }
    }
}
