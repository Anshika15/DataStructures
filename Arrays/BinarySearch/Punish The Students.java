/* 

Punish The Students

1. A Professor conducts a Computer Science paper for N students. He had strictly instructed all students to sit according to their roll numbers. However when he started checking the papers, he found out that all the papers were randomly ordered because the students had sat randomly during the exam instead of sitting according to their roll numbers. The order is given in list of integers roll[ ]. The professor became very angry and he wanted to teach the students a lesson.
2. He decided to sort the papers according to roll numbers by Bubble Sort and count the number of swaps required for each and every student and deduct as many marks of a student as were the number of swaps required for that student. The marks of every student is given in list of integers marks[ ] in the order in which they were sitting. However he also has to maintain the class average greater than or equal to a set minimum avg, else he may lose his job. 
3. The Professor wants to know whether he should punish the students or save his job.

*/

import java.util.*;
import java.io.*;

public class Main {

  public static boolean shouldPunish(int[]roll, int[]marks, double avg) {
    
    // count all the swaps which occurs in bubble sort but this time add +2 instead of +1 as we have to calculate swap for every element

    int n = roll.length;
    int swap = 0;
    for(int i = 0; i < n-1; i++)
    {
      for(int j = 0; j < n-i-1; j++)
      {
        if(roll[i] > roll[i+1])
        {
          int temp = roll[i];
          roll[i] = roll[i+1];
          roll[i+1] = temp;
          swap += 2;
        }
      }
    }

    int oldmarks = 0;

    for(int i = 0; i < n; i++)
    {
      oldmarks += marks[i];
    }

    int newMarks = oldmarks - swap;

    double navg = (newMarks * 1.0)/n;

    return navg >= avg;

  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]roll = new int[n];

    for (int i = 0; i < n; i++) {
      roll[i] = scn.nextInt();
    }

    int[]marks = new int[n];

    for (int i = 0; i < n; i++) {
      marks[i] = scn.nextInt();
    }

    double avg = scn.nextDouble();

    System.out.println(shouldPunish(roll, marks, avg));
  }
}
