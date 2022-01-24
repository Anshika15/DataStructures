/*

Pairs Of Non Coinciding Points

In a given cartesian plane, there are N points. We need to find the Number of Pairs of  points(A, B) such that

Point A and Point B do not coincide.
Manhattan Distance and the Euclidean Distance between the points should be equal.
Note: Pair of 2 points(A,B) is considered same as Pair of 2 points(B ,A).
Manhattan Distance = |x2-x1|+|y2-y1|
Euclidean Distance   = ((x2-x1)^2 + (y2-y1)^2)^0.5, where points are (x1,y1) and (x2,y2).

*/

import java.io.*;
import java.util.*;

public class Main {
  public static int numOfPairs(int[] X, int[] Y, int N) {
    //Code Here
    /* store the count of x coordinates, y coordinates separately and together */
    
    /* to remove duplicacy we will remove the 2* freq of (x,y) together if occuring multiple times */
    
    /* by comparing two formulas we came to a conclusion that if these conditions are true x1 == x2 || y1 == y2 || (x1==x2 && y1 == y2) then both distances are equal */
        
        // as point a and b do not therefore (x1==x2 && y1 == y2) can't be true
        
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        HashMap<String, Integer> xy = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < X.length; i++)
        {
            int xval = X[i];
            int yval = Y[i];
            
            String xyval = xval + "*" + yval;
            
            int xFreq = x.getOrDefault(xval, 0);
            int yFreq = y.getOrDefault(yval, 0);
            int xyFreq = xy.getOrDefault(xyval, 0);
            
            sum += xFreq + yFreq - 2*xyFreq;
            
            x.put(xval, xFreq+1);
            y.put(yval, yFreq+1);
            xy.put(xyval, xyFreq+1);
        }
        return sum;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(read.readLine());

      String S1[] = read.readLine().split(" ");
      String S2[] = read.readLine().split(" ");

      int[] X = new int[N];
      int[] Y = new int[N];

      for (int i = 0; i < N; i++)
      {
        X[i] = Integer.parseInt(S1[i]);
        Y[i] = Integer.parseInt(S2[i]);
      }

      System.out.println(numOfPairs(X, Y, N));
    }
  }
}
