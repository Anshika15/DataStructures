/* 

Toppers Of Class

1. There is a class of N students and the task is to find the top K marks scorers. 
2. You need to print the index of the toppers of the class which will be same as the index of the student in the input array (use 0-based indexing). 
3. First print the index of the students having highest marks then the students with second highest and so on. If there are more than one students having same marks then print their indices in ascending order.Suppose k = 2 and the students having highest marks have indices 0 and 5 and students having second highest marks have indices 6 and 7 then output will be 0 5 6 7.


*/

import java.util.*;
import java.io.*;

public class Main {

  static class Pair implements Comparable<Pair>{
    int idx;
    int val;

    Pair(){}

    Pair(int val, int idx)
    {
      this.val = val;
      this.idx = idx;
    }

    public int compareTo(Pair p)
    {
      if(this.val != p.val)
        return this.val - p.val;
      return p.idx - this.idx;
    }
  }

  public static int[] kToppers(int[]marks, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    int res[] = new int[k];

    for(int i = 0; i < marks.length; i++)
    {
      if(i < k)
      {
        pq.add(new Pair(marks[i], i));
      }
      else if(marks[i] > pq.peek().val)
      {
        pq.remove();
        pq.add(new Pair(marks[i], i));
      }
    }

    int idx = k-1;
    while(pq.size() > 0)
    {
      res[idx] = pq.remove().idx;
      idx--;
    }


    return res;
  }

  public static void main(String[]args) {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]marks = new int[n];

    for (int i = 0; i < n; i++) {
      marks[i] = scn.nextInt();
    }

    int k = scn.nextInt();

    int[]ans = kToppers(marks, k);

    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }

  }
}
