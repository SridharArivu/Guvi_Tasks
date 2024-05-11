import java.util.*;

public class utils {
    public static int generateAccountNumber() {
        Random random = new Random();
        int accountNumber = random.nextInt(90000) + 10000;
        return accountNumber;
    }

    public static int generateCustomerId() {
        Random random = new Random();
        int customer_id = random.nextInt(10) + 90;
        return customer_id;
    }

    public static Account getAccount (long account_number, List<Account> account){
        for(Account acc : account){
            if(acc.get_Account_number() == account_number){
                return acc;
            }
        }
        return null;
    }
}
