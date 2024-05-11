import java.text.DecimalFormat;
public class Product implements Taxable{

    private Integer pid;
    private double price;
    private Integer quantity;

    public Product(Integer pid, double price, Integer quantity){
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
     public double calcTax(){
        double finalAmount = price * quantity;
        double saleTax = finalAmount * Taxable.SALES_TAX;

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(saleTax));
     }

    public Integer getPid(){
        return pid;
    }
    public double getPrice(){
        return price;
    }
    public Integer getQunatity(){
        return quantity;
    }
    public void setPid(Integer pid){
        this.pid = pid;
     }
     public void setPrice(double price){
         this.price = price;
     }
     public void setQunatity(Integer quantity){
         this.quantity = quantity;
     }
     
  
    
}
