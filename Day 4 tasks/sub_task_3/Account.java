public class Account {
    private Integer customer_id;
    private String name;
    private long account_number;
    private double account_balance;

    public Account(Integer id, String name, long account_number, double account_balance){
        this.customer_id = id;
        this.name = name;
        this.account_number = account_number;
        this.account_balance = account_balance;
    }
    public Account(){

    }
    public long get_Account_number() {
        return account_number;
      }

    public boolean deposit(long account_number, double amount){
        if(this.account_number == account_number){
            this.account_balance += amount;
            return true;
        }
        return false;
    }
    public boolean withdraw(long account_number, double amount){
        if(this.account_number == account_number){
            this.account_balance -= amount;
            return true;
        }
        return false;
    }
    public double balance(long account_number){
        if(this.account_number == account_number){
            return account_balance;
        }
        return 0;
    }

    public long getAccountNumber(String Name, Integer customer_id){
        if(this.name == Name && this.customer_id == customer_id){
            return account_number;
        }
        return 0;
    }
}
