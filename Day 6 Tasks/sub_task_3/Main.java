import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        String weeks[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Day Position from 0 - 6");
            int position = sc.nextInt();
            if(position >= 0 && position <= 6 ){
                System.out.println("Day "+position + " in a week is "+ weeks[position]);
                sc.close();
                break;
            }else{
                continue;
            }
        }
    }
}