/* 

Ishaan And Sticks

Ishaan has a craving for sticks. He has N sticks. He observes that some of his sticks are of the same length, and thus he can make squares out of those.
He wants to know how big a square he can make using those sticks as sides. Since the number of sticks is large, he can't do that manually. Can you tell him the maximum area of the biggest square that can be formed?
Also, calculate how many such squares can be made using the sticks.

*/

import java.util.*;
import java.io.*;

public class Main {

  public static ArrayList<Integer>  solve(int[]arr) {

    int maxSq = 0;
    int numsSq = 0;


    HashMap<Integer, Integer> map = new HashMap<>(); // freq map
    for(int val : arr)
    {
      map.put(val, map.getOrDefault(val, 0)+1);
    }

    for(int key : map.keySet())
    {
      int freq = map.get(key);

      // if freq >= 4 only then we can make sqaure
      // number of squares == freq/4;

      if(freq >= 4)
      {
        int area = key*key;
        if(area > maxSq)
        {
          maxSq = area;
          numsSq = freq/4;
        }
      }
    }

    ArrayList<Integer> l = new ArrayList<Integer>();
    if(maxSq == 0)
    {
      l.add(-1);
      return l;
    }
    else
    {
      l.add(maxSq);
      l.add(numsSq);
      return l;
    }

  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    ArrayList<Integer>ans = solve(arr);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}
