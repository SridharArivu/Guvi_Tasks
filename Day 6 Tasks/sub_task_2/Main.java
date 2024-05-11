import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidAgeException {
        Scanner scanner = new Scanner(System.in);
        String voterId = null;
        String name = null;
        Integer age = null;

        Voter voter = null;

        try {
            System.out.println("Enter voter ID:");
            voterId = scanner.nextLine();

            System.out.println("Enter name:");
            name = scanner.nextLine();

            System.out.println("Enter age:");
            age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            voter = new Voter(voterId, name, age);
        } catch (InvalidAgeException e) {
            while (age < 18) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Enter age Again:");
                age = scanner.nextInt();
            }
            voter = new Voter(voterId, name, age); 
        } finally {
            System.out.println("Voter created successfully:");
            System.out.println("Voter ID: " + voter.getVoterId());
            System.out.println("Name: " + voter.getName());
            System.out.println("Age: " + voter.getAge());
            scanner.close();
        }
    }
}