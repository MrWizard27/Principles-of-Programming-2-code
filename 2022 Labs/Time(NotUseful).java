public class Time{
  public static void main(String[] args){

    double hour = 10.00 ;
    double minute = 40.00 ;
    double second = 48.00 ;
    // seconds in an hour
    double hs = (hour*3600) ;
    // seconds in a minute
    double ms = (minute*60) ;
    //total seconds that have passed so far
    double ts = (second + ms + hs) ;
    //total seconds in a day
    double ds = 86400.00 ;
    //Seconds left in a day
    double sl = (ds - ts) ;
    //Second percentage (percent of the day left)
    double sp = ((ts / ds) * 100) ;

    System.out.println(ts + " Seconds since midnight") ;
    System.out.println(sl + " Seconds left in the day") ;
    System.out.println(sp + "% of the day has passed") ;

  }
}
