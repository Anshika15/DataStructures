import java.util.*;

public class Main {

  /*

  1. You are given an array(arr) which contains only 0's and 1's.
  2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most one zero.

  */

  public static int solution(int[] arr) {

    int j = -1;
    int c = 0;
    int res = 0;
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] == 0)
        c++;

      while (c > 1)
      {
        j++;
        if (arr[j] == 0)
          c--;
      }
      res = Math.max(i - j, res);
    }

    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i  < n; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}
