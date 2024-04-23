public class Array{
  public static void main(String[] args){
    double realprice = 0;
    double percentprice = 0;
    double[] prices = {10.25, 5.15, 7.19, 11.27, 3.25};

    for (int i = 0; i < prices.length; i++){

      System.out.println("Initial Price is $" + prices[i]);

      realprice = prices[i] + (prices[i] * 0.15);

      System.out.printf("The price, increased by 15%%, is $%.2f \n\n", realprice);
    }
  }
}
