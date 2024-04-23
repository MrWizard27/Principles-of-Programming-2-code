//This code was made by Michael Plafcan on 3/2/2023
public class Student{
    //instance variables
    private String name;
    private int[] QuizScores = new int[9];
    private int MidTermScore;
    private int FinalExamScore;
    
    public Student(String name){
        //initializes each variable to 0
       this.name = name;
       this.MidTermScore = 0;
       this.FinalExamScore = 0;
        //iterates through the quiz scores array and sets all values to 0
       for (int x = 0;x < QuizScores.length; x++){
        this.QuizScores[x] = 0;
       }

    }

    public void setQuizScore(int quizNum, int quizScore){
        //this checks to make sure the request is in bounds with what the array can hold so no quiznum over 9 and under 1
        if (quizNum > 0 && quizNum<10){
        this.QuizScores[quizNum-1] = quizScore;
        }
    }

    public void setMidtermScore(int score){
        //sets midterm score to whatever you choose
        this.MidTermScore = score;
    }

    public void setFinalScore(int score){
        //sets final exam score to whatever you choose
        this.FinalExamScore = score;
    }

    public double getQuizAve(){
        //saves the total amount minus the 2 lowest
        double QuizAve = 0;
        //keeps account of what the current smallest number is
        int small = 10;
        //the location of the first smallest number
        int smallLoc = 0;
        //the location of the second smallest number
        int smallLoc2 = 0;

        //Goes through QuizScores to find the smallest numbers
        for (int count = 0;count < QuizScores.length; count++){
             //checks if number is smaller than current smallest
             if (QuizScores[count]<=small){
                //updates small to the new smallest number
                small = QuizScores[count];
                //saves the location of that number
                smallLoc = count;
             }

        }
        //this is because there was a bug where if the first number was the smallest, since both are set at the first number, it would never change to the second smallest number cause it alread had the smallest number
          smallLoc2 = smallLoc + 1;
          //resets small
          small = 10;

        for (int count2 = 0;count2 < QuizScores.length; count2++){
             //checks to see if the number is smaller than the current smallest and makes sure it is the second smallest with != smallLoc
            if (QuizScores[count2]<=small && count2 != smallLoc){
                small = QuizScores[count2];
                smallLoc2 = count2;
            }

        }
        //sets the smallest numbers to 0 so they don't effect the average
        QuizScores[smallLoc] = 0;
        QuizScores[smallLoc2] = 0;
        //adds all the numbers in quizScores together
        for (int x = 0;x < QuizScores.length; x++){
            QuizAve += this.QuizScores[x];
        }
        //averages QuizAve minus 2 to account for the 2 smallest numbers
        return QuizAve / (QuizScores.length-2);
    }

    public double getSemesterAve(){
        //converts this to 35% weight ((7/20=.35)quiz*10*7/20 = quiz*70/20 = quiz*7/2)
        double QuizAveWeighted = getQuizAve()*7.0/2.0;
        //converts to 25% weight (1/4=.25)
        double MidtermWeighted = this.MidTermScore/4.0;
        //converts to 40% weight (2/5=.40)
        double FinalExamWeighted = (this.FinalExamScore*2.0)/5.0;

        //gets the sum of all the percents
        return QuizAveWeighted + MidtermWeighted + FinalExamWeighted;

    }

    public char letterGrade(){
        //this is so I didn't have to type "getSemesterAve()" everytime
        double score = getSemesterAve();
        //this returns letters based on what score you got
        if (score >= 90){
            return 'A';
        } else if (score >= 80){
            return 'B';
        } else if (score >= 70){
            return 'C';
        } else if (score >= 60){
            return 'D';
        } //returns if score is less than 60
            return 'F';
    }

    public String toString(){
        //formats to print instance variable like this
//Names's Grades
//-------------------------

//    Quiz Average: 0.0
//    Midterm Grade: 0%
//    Final Exam Grade: 0%

//-------------------------
//Average Semester Grade: 0.0%  F

        return this.name + "'s Grades\n-------------------------\n\n    Quiz Average: " + getQuizAve() + "\n    Midterm Grade: " + this.MidTermScore + "%\n    Final Exam Grade: " + this.FinalExamScore + "%\n\n-------------------------\nAverage Semester Grade: " + getSemesterAve() + "%  " + letterGrade() + "\n\n\n";

    }
}