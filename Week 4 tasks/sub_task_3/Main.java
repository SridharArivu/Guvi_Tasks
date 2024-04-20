import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Account> accountsList = new ArrayList<>();


        while (true) {
            System.out.println();
           System.out.println("Enter what actions you need to perfrom"); 
           System.out.println("List of actions: 1.Create Account, 2.Deposit Money, 3.Withdraw Money, 4.Balance Check, 5. Exit"); 
           int actions = sc.nextInt();
           
           switch (actions) {
            case 1:{
                System.out.print("Enter Your Name: ");
                String name = sc.next();
                
                System.out.print("Enter initial deposit amount: ");
                double amount = sc.nextDouble();

                int customer_id = utils.generateCustomerId();
                long account_number = (long) utils.generateAccountNumber();
                Account account = new Account(customer_id , name, account_number, amount);
                accountsList.add(account);

                System.out.println("Account Created Successfully");
                System.out.println("Please save your account number: "+account.getAccountNumber(name, customer_id));
                break;
            }
            case 2:{
                System.out.print("Enter Your Account Number: ");
                long account_number = sc.nextLong();
                
                System.out.print("Enter Your amount: ");
                double amount = (double) sc.nextDouble();

                Account account = utils.getAccount(account_number, accountsList);
                boolean result = account.deposit(account_number, amount);
                
                if(result){
                    System.out.println("Your Transaction was successfully Completed");
                    System.out.println("Available Balance: Rs."+ account.balance(account_number));
                }else System.out.println("Account not found");

                break;
            }
            case 3:{
                System.out.print("Enter Your Account Number: ");
                long account_number = sc.nextLong();
                
                System.out.print("Enter Your amount: ");
                double amount = (double) sc.nextDouble();

                Account account = utils.getAccount(account_number, accountsList);
                boolean result = account.withdraw(account_number, amount);
                
                if(result){
                    System.out.println("Your Transaction was successfully Completed");
                    System.out.println("Available Balance: Rs."+ account.balance(account_number));
                }else System.out.println("Account not found");
                break;
            }
            case 4:{
                System.out.print("Enter Your Account Number: ");
                long account_number = sc.nextLong();

                Account account = utils.getAccount(account_number, accountsList);
                double result = account.balance(account_number);

                if(result == 0){
                    System.out.println("Account not found");
                }else System.out.println("Available Balance: Rs."+result);
                break;
            }
            case 5:{
                sc.close();
                break;
            }
            default:
                System.out.print("Invalid Actions Performed");
                break;
           }
           if(actions == 5) break;
        }
    }
}
