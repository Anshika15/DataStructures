import java.util.*;

public class Main {

/* 

Minimum Domino Rotations For Equal Row

1. In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. 
2. A domino(Dice Structured) is a tile with two numbers from 1 to 6 - one on each half of the tile.
3. We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
4. Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
5. If it cannot be done, return -1.


*/


  public static int minDominoRotations(int[] tops, int[] bottoms) {
      
      /* 
      
      num1 = tops[0], num2 = bottom[0]
       case1 => make num1 in row1
       case2 => make num1 in row2
       case3 => make num2 in row1
       case4 => make num2 in row2
       
       if we are not able to handle num1 and num2 then not possible
      
      */
      
     int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
     int num1 = tops[0];
     int num2 = bottoms[0];
     
     for(int i = 0; i < tops.length; i++)
     {
         // for num1
         
         // count1 = number of swapping required to make top array as num1
         if(count1 != Integer.MAX_VALUE){
             if(tops[i] == num1)
             {
                 // nothing to do
             }
             else if(bottoms[i] == num1)
             {
                 count1++; // 1 swapping
             }
             else
             {
                 count1 = Integer.MAX_VALUE; // not possible to make num1
             }
         }
         
         // count2 = number of swapping required to make bottom array as num1
         
         if(count2 != Integer.MAX_VALUE){
             if(bottoms[i] == num1)
             {
                 // nothing to do
             }
             else if(tops[i] == num1)
             {
                 count2++; // 1 swapping
             }
             else
             {
                 count2 = Integer.MAX_VALUE; // not possible to make num1
             }
         }
         
         // for num2
         
         // count3 = number of swapping required to make top array as num2
         
         if(count3 != Integer.MAX_VALUE){
             if(tops[i] == num2)
             {
                 // nothing to do
             }
             else if(bottoms[i] == num2)
             {
                 count3++; // 1 swapping
             }
             else
             {
                 count3 = Integer.MAX_VALUE; // not possible to make num1
             }
         }
         
         // count4 = number of swapping required to make bottom array as num2
         
         if(count4 != Integer.MAX_VALUE){
             if(bottoms[i] == num2)
             {
                 // nothing to do
             }
             else if(tops[i] == num2)
             {
                 count4++; // 1 swapping
             }
             else
             {
                 count4 = Integer.MAX_VALUE; // not possible to make num1
             }
         }
         
     }
      
      int res = Math.min(count1, Math.min(count2, Math.min(count3, count4)));
      if(res == Integer.MAX_VALUE)
        return -1;
    return res;
      
      // find min from each counts if min = Integer.MAX_VALUE return -1;
      
      
      /* 
      another solution
      
        int countA[] = new int[7];
        int countB[] = new int[7];
        int same[] = new int[7];
        
        for(int i = 0; i < tops.length; i++)
        {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if(bottoms[i] == tops[i])
                same[bottoms[i]]++;
        }
        
        for(int i = 1; i < 7; i++)
        {
            if(countA[i] + countB[i] - same[i] == tops.length)
                return tops.length - Math.max(countA[i] , countB[i]);
        }
        return -1;
      
      */

  }

  //~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] top = new int[n];
    int[] bottom = new int[n];

    // read top
    for (int i = 0; i < top.length; i++) {
      top[i] = scn.nextInt();
    }
    // read bottom
    for (int i = 0; i < bottom.length; i++) {
      bottom[i] = scn.nextInt();
    }

    int rotation = minDominoRotations(top, bottom);
    System.out.println(rotation);
  }
}
