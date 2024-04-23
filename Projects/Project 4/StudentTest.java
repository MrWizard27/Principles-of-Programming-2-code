/***********************
 *
 *   StudentTest - test driver for the Student class.
 *
 *   Author:   Shawn Brenneman
 *   Author:   Bob Browder
 *   Date:     2015-Oct-28
 *   Updated:  2023-Feb-17
 *
 ***********************/   

public class StudentTest 
{
    public static void main(String[] args) {
        Student[] student = new Student[7];

        student[0] = new Student("Ken McSnardle");
        System.out.println(student[0]);
        student[0].setQuizScore(1,9);
        student[0].setQuizScore(2,7);
        student[0].setQuizScore(3,5);
        student[0].setQuizScore(4,9);
        student[0].setQuizScore(5,8);
        student[0].setQuizScore(6,6);
        student[0].setQuizScore(7,10);
        student[0].setQuizScore(8,9);
        student[0].setQuizScore(9,8);
        student[0].setMidtermScore(89);
        student[0].setFinalScore(91);

        student[1] = new Student ("Doogle O'Klartz");
        student[1].setQuizScore(1,4);
        student[1].setQuizScore(2,4);
        student[1].setQuizScore(3,4);
        student[1].setQuizScore(4,4);
        student[1].setQuizScore(5,4);
        student[1].setQuizScore(6,4);
        student[1].setQuizScore(7,4);
        student[1].setQuizScore(8,4);
        student[1].setQuizScore(9,4);
        student[1].setMidtermScore(44);
        student[1].setFinalScore(88);

        student[2] = new Student ("Lady Gaga");
        student[2].setQuizScore(1,1);
        student[2].setQuizScore(2,2);
        student[2].setQuizScore(3,3);
        student[2].setQuizScore(4,4);
        student[2].setQuizScore(5,5);
        student[2].setQuizScore(6,6);
        student[2].setQuizScore(7,7);
        student[2].setQuizScore(8,8);
        student[2].setQuizScore(9,9);
        student[2].setMidtermScore(62);
        student[2].setFinalScore(91);

        student[3] = new Student ("Fred Flintstone");
        student[3].setQuizScore(1,9);
        student[3].setQuizScore(2,7);
        student[3].setQuizScore(3,5);
        student[3].setQuizScore(4,9);
        student[3].setQuizScore(5,8);
        student[3].setQuizScore(6,5);
        student[3].setQuizScore(7,6);
        student[3].setQuizScore(8,7);
        student[3].setQuizScore(9,7);
        student[3].setMidtermScore(76);
        student[3].setFinalScore(93);

        student[4] = new Student ("Jerry Javoovoo");
        student[4].setQuizScore(1,4);
        student[4].setQuizScore(2,6);
        student[4].setQuizScore(3,4);
        student[4].setQuizScore(4,6);
        student[4].setQuizScore(5,5);
        student[4].setQuizScore(6,5);
        student[4].setQuizScore(7,3);
        student[4].setQuizScore(8,3);
        student[4].setQuizScore(9,10);
        student[4].setMidtermScore(99);
        student[4].setFinalScore(100);

        student[5] = new Student ("Zinky Poo McJaffrey");
        student[5].setQuizScore(0,9);
        student[5].setQuizScore(1,9);
        student[5].setQuizScore(2,7);
        student[5].setQuizScore(3,5);
        student[5].setQuizScore(4,9);
        student[5].setQuizScore(5,8);
        student[5].setQuizScore(7,10);
        student[5].setQuizScore(8,9);
        student[5].setQuizScore(9,8);
        student[5].setQuizScore(10,8);

        student[6] = new Student ("George Foreman IV");
        student[6].setQuizScore(1,10);
        student[6].setQuizScore(2,10);
        student[6].setQuizScore(3,10);
        student[6].setQuizScore(4,10);
        student[6].setQuizScore(5,9);
        student[6].setQuizScore(6,9);
        student[6].setQuizScore(7,1);
        student[6].setQuizScore(8,1);
        student[6].setQuizScore(9,0);
        student[6].setMidtermScore(100);
        student[6].setFinalScore(96);

        for (int ii=0; ii<student.length; ii++)
        {
            System.out.println(student[ii]);
        }
    } //main

}
