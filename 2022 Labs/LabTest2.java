//this code was made by Michael Plafcan on 2/7/23
import java.util.Scanner;
public class Labtest2{
    public static void main(String[] args){
        //Declares scanner object
        Scanner input = new Scanner(System.in);

        //Creates n to stop the while loop and og array length so whatever the end input is can be used outside the loop
        int n = 0;
        int ogArrayLength = 0;

        //loops until the user inserts a number that is greater than 1 
        while (n==0){
        System.out.println("How long would you like the array to be (must be greater than 1)");
        ogArrayLength = input.nextInt();
        if (ogArrayLength>=1){
            n = 1;
        }else{
            System.out.println("That is too small of a number, please try again");
        }
        }

        //Declares the 2 arrays
        int array1[] = new int[ogArrayLength];
        int array2[] = new int[ogArrayLength*2];

        //Fills in the first array
        for (int x = 0; x<array1.length;x++){
            System.out.println("Please give me a number for the array");
            array1[x] = input.nextInt();
        }

        //fills in the second array
        array2[array2.length-1] = array1[array1.length-1];

        //prints out both arrays
        System.out.println("Array 1");
        for (int x = 0; x<array1.length;x++){
            System.out.print(array1[x] + ",");
        }
        System.out.println("\nArray 2");
        for (int x = 0; x<array2.length;x++){
            System.out.print(array2[x] + ",");
        }
    }
}