package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = sc.nextInt();
        if(Num <= 0){
            if(Num == 0){
                System.out.println("Given Number " + Num + " neutral integer");
            }else System.out.println("Given Number " + Num + " is Negative");
        }else System.out.println("Given Number " + Num + " is Positive");
    }
}
