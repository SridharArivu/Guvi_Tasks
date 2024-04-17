package task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        System.out.println("Three smallest Number among given three numbers is "+findMaximum(A,findMaximum(B,C)));

    }
    public static int findMaximum(int a, int b){
        return (a < b) ? a : b;
    }
}
