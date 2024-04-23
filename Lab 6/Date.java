public class Date {
    private int year;
    private int day;
    private int month;
    
public Date(){
    this.year = 1776;
    this.day = 4;
    this.month = 7;
}
public Date(int year, int day, int month){
    this.year = year;
    this.day = day;
    this.month = month;
}
public String toString(){

    return String.format("%02d/%02d/%02d", this.month, this.day, this.year);

}
}