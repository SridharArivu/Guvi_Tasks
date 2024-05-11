import java.util.*;

public class Main{
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc","","bc","efg","abcd","","jkl");

        int count = 0;

        System.out.print("Non Empty Strings : ");
        for(String s: list){
            if(s == "") count ++;
            else System.out.print(s + " ");
        }
        if(count > 0){
            System.out.println("\nThe List Contains "+count+" Empty Strings");
        }
    }
}