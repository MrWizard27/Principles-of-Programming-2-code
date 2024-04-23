public class PickleTime{
    public static void Cucumbers_Available(double year){
      double pa = year*10 ;
      System.out.println(pa + " Pickles Available");
  }
    public static void Per_Gallon(double day){
      double pg = day*4 ;
      System.out.println(pg + " Cucumbers Per Gallon");
  }
    public static void Per_Batch(double month, double day){
      double ps = month ;
      double pg = day*4 ;
      double pb = ps*pg ;
      System.out.println(pb + " Cucumber Per batch");
  }
    public static void Batches_Requires(double month, double day, double year){
      double pg = day*4 ;
      double ps = month ;
      double pa = year*10 ;
      double pb = ps*pg ;
      double br = pa/pb ;
      System.out.println(br + " Total Batches Required");

  }
    public static void main(String[] args){
      double month = 9.00;
      double year = 2004.00;
      double day = 27.00;
      Cucumbers_Available(year);
      Per_Gallon(day);
      Per_Batch(day, month);
      Batches_Requires(day, month, year);
    }
  }
