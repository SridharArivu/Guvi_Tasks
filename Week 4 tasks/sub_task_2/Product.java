public class Product implements Comparable<Product>{

    private Integer pid;
    private double price;
    private Integer quantity;

    public Product(Integer pid, double price, Integer quantity){
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
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
     
     @Override
    public int compareTo(Product otherProduct) {
        return Double.compare(this.price, otherProduct.price);
    }
    
}
