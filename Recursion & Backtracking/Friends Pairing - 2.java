/* 

Friends Pairing - 2

1. You are given an integer n, which represents n friends numbered from 1 to n.
2. Each one can remain single or can pair up with some other friend.
3. You have to print all the configurations in which friends can remain single or can be paired up.


*/

import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void solution(int i, int n, boolean[] used, String asf) {
    if(i > n)
    {
        System.out.println(counter + "." + asf);
        counter++;
        return;
    }
    if(used[i] == true)
    {
        solution(i+1, n, used, asf);
    }
    else
    {
        used[i] = true;
        solution(i+1, n, used, asf + "(" + i + ") ");
        for(int j = i+1; j <= n; j++)
        {
            if(used[j] == false){
                used[j] = true;
                solution(i+1, n, used, asf + "(" + i + "," + j + ") ");
                used[j] = false;
            }
        }
        used[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}
