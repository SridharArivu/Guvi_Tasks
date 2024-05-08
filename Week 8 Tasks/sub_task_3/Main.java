import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
    
        List<String> studentNames = Arrays.asList("Ananya", "Aarav", "Aditi", "Aakash", 
                                                "Neha", "Rohan", "Priya", "Arjun", 
                                                "Kavya", "Vikram");
        System.out.println("\nThe List of Students : "+studentNames);

        List<String> filteredNames = studentNames.stream().filter(stu -> stu.charAt(0) == 'A')
                                                            .collect(Collectors.toList());
        System.out.println("\nThe Selected Students are : "+filteredNames);
    }
}
