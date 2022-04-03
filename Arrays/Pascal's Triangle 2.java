import java.util.*;

/* 

Pascal's Triangle 2

Description : 
1. Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
2. In Pascal's triangle, each number is the sum of the two numbers directly above OR it is also a pattern which can be made from combination maths
3. For More clearance, watch video till explanation of question.
eg. 
row 0 -> 1
row 1 -> 1 1
row 2 -> 1 2 1
row 3 -> 1 3 3 1
row 4 -> 1 4 6 4 1

*/

public class Main {

  public static ArrayList<Integer> pascalRow(int r) {
        /* 
        
        nc0 ==> n = 1 (rowIdx)
        
        nc0 nc1 ===> n = 2
        
        nc0 nc1 nc2 ==> n = 3
        
        ncr * factor = ncr+1 ==> factor = (n-r)/(r+1)
        
        i = row, j = col ;
        intilal val = 1 as nc0 = 1
        multiply val with factor to generate next digit i.e (i-j)/j+1
        
        */
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        int val = 1;
        for(int j = 0; j <= r; j++)
        {
            res.add(val);
            val = val * (r-j)/(j+1);
        }
       return res; 
  }

  // ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    ArrayList<Integer> res = pascalRow(n);
    for (int val : res) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}
