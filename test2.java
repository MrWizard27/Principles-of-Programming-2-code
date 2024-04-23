public class test2{
    public static void main(String[] args){


      int[] QuizScores = {7,7,4,8,4,6,7,3,5};


      int small = 10;
        int smallLoc = 0;
        int smallLoc2 = 0;

        for (int count = 0;count < QuizScores.length; count++){
             
             if (QuizScores[count]<=small){
                small = QuizScores[count];
                smallLoc = count;
             }
          }
          smallLoc2 = smallLoc + 1;
          small = 10;
            for (int count2 = 0;count2 < QuizScores.length; count2++){
             
             if (QuizScores[count2]<=small && count2 != smallLoc){
                small = QuizScores[count2];
                smallLoc2 = count2;
               }
            }
    System.out.println(QuizScores[smallLoc] + ", " + QuizScores[smallLoc2]);
    System.out.println(smallLoc + ", " + smallLoc2);
    }
}
