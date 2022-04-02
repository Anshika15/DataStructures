import java.util.*;

public class Main {
    /* 
    
    Maximum Swap
    
    1. You are given a number in form of String. 
    2. You can swap two digits at most once to     get the maximum valued number in that string.
    3. Return the maximum valued number you can     get in form of string.
    
    */

    /* 
    
    swapping would be done at max possible left i.e most significant digit
    
    approach1 => take a loop of i and place j at i+1 to end and check if any number greater than curr number exists swap and calculate max ans possible =>> O(n^2)
    
    approach2 => O(n) time and O(n) space for right max array
    
    i) find right max index -> O(n)
    
    ii) travel and figure out positions for swapping => arr[i] != arr[rightmax[i]] (swap and it is a valid ans)
    
    iii) return ans
    
    
    approach3 => O(n) time, O(10) space ==> O(1) in space
    
    i) find last index of each digit i.e for 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    
    ii) traverse the string and if a valid digit greater than curr digit exists after that then swap it and return ans;
    
    */

  public static String maximumSwap(String num) {
      
      // prepare last idx of each digit
      int[] lastIdx = new int[10];
      
      for(int i = 0; i < num.length(); i++)
      {
          char ch = num.charAt(i);
          lastIdx[ch - '0'] = i;
      }
      
      // figure out postion for swapping
      boolean flag = false;
      String res = "";
      for(int i = 0; i < num.length(); i++)
      {
          char ch = num.charAt(i);
          int currDigit = ch - '0';
          for(int j = 9; j > currDigit; j--)
          {
              if(i < lastIdx[j])
              {
                  // swap and break;
                  flag = true;
                  res = swap(num, i, lastIdx[j]);
                  break;
              }
          }
          if(flag == true)
            break;
      }
      return res;

  }

  static String swap(String num, int i, int j)
  {
      StringBuilder sb = new StringBuilder(num);
      
      sb.setCharAt(i, num.charAt(j));
      sb.setCharAt(j, num.charAt(i));
      
      return sb.toString();
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String ans = maximumSwap(str);
    System.out.println(ans);
  }
}
