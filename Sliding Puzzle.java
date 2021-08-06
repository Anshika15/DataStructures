

import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] arr = new int[2][3];

    for (int i = 0; i < 2; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(slidingPuzzle(arr));
  }

  public static int slidingPuzzle(int[][] board) {

    LinkedList<String> q = new LinkedList<>();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[i].length; j++)
      {
        sb.append(board[i][j]);
      }
    }

    String str = sb.toString();
    q.add(str);
    String target = "123450";

    int dirs[][] = {
      {1, 3},
      {0, 2, 4},
      {1, 5},
      {0, 4},
      {3, 1, 5},
      {4, 2}
    };

    HashSet<String> vis = new HashSet<>();

    int level = 0;
    while (q.size() > 0)
    {
      int size = q.size();

      while (size-- > 0) {

        String rem = q.removeFirst();
        if (rem.equals(target))
        {
          return level;
        }

        int index = -1;
        for (int j = 0; j < rem.length(); j++)
        {
          if (rem.charAt(j) == '0')
          {
            index = j;
            break;
          }
        }

        int swap[] = dirs[index];

        for (int i = 0; i < swap.length; i++)
        {
          String strToBeAdded = swapString(rem, index, swap[i]);
          if (vis.contains(strToBeAdded))
          {
            continue;
          }
          q.addLast(strToBeAdded);
          vis.add(strToBeAdded);
        }

      }
      level++;
    }

    return -1;

  }

  public static String swapString(String st, int i, int j)
  {
    StringBuilder sb = new StringBuilder(st);
    sb.setCharAt(i, st.charAt(j));
    sb.setCharAt(j, st.charAt(i));
    return sb.toString();
  }
}
