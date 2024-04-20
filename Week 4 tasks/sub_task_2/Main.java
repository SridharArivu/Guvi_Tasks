import java.util.*;
public class Main {

    public static double getTotalAmount(List<Product> productsList){
        double totalAmount = 0;

        for(Product product: productsList ){
            double sum = product.getPrice() * product.getQunatity();
            totalAmount += sum;
        }
        return totalAmount;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();

       for(int i=1; i<=5; i++){

        System.out.println("Enter Details of Product "+i);
        System.out.println();

        System.out.print("Enter Product ID:");
        int pid = sc.nextInt();

        System.out.print("Enter Product Price:");
        double price = sc.nextInt();

        System.out.print("Enter Product Quantity:");
        int quantity = sc.nextInt();
        Product product = new Product(pid, price, quantity);
        productList.add(product);
       }

       Collections.sort(productList);

       Product highestPrice = productList.get(productList.size()-1);
       System.err.println("The Product Id of the Product with Highest price is "+highestPrice.getPid());

       double totalAmount = getTotalAmount(productList);
       System.err.println("The Total Amount spent on all Products are Rs."+totalAmount);

       sc.close();
    }
}
