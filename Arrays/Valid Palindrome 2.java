/*

1. Given a string s.
2. Return true if the s can be palindrome after deleting at most one character from it.

*/

import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
  public static boolean validPalindrome(String s) {
    int i = 0;
    int j = s.length()-1;

    while(i < j)
    {
      if(s.charAt(i) == s.charAt(j))
      {
        i++;
        j--;
      }
      else
      {
        // skip char from left or right -> delete at most 1 char
        return isPossible(s, i+1, j) || isPossible(s, i, j-1);
      }
    }
    return true;
  }

  public static boolean isPossible(String s, int i, int j)
  {
    while(i < j)
    {
      if(s.charAt(i) == s.charAt(j))
      {
        i++;
        j--;
      }
      else{
        return false;
      }
    }
    return true;
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    boolean res = validPalindrome(str);
    System.out.println(res);
  }
}
