import java.io.*;
import java.util.*;

public class Main {

  public static void solution(char[][] arr, String[] words, int vidx) {
    //write your code here
    
    if(vidx == words.length)
    {
        print(arr);
        return;
    }
    
    String word = words[vidx];
    for(int i = 0; i < arr.length; i++)
    {
        for(int j = 0; j < arr[i].length; j++)
        {
            if(arr[i][j] == '-' || arr[i][j] == word.charAt(0))
            {
                if(canWePlaceWordHorizontally(arr, word, i, j))
                {
                    boolean placed[] = placedTheWordHorizontally(arr, word, i, j);
                    solution(arr, words, vidx+1);
                    unplaceThePlacedWordHorizontally(arr, placed, i, j); //backtrack only those chars we placed
                }
                
                if(canWePlaceWordVertically(arr, word, i, j))
                {
                    boolean placed[] = placedTheWordVertically(arr, word, i, j);
                    solution(arr, words, vidx+1);
                    unplaceThePlacedWordVertically(arr, placed, i, j);
                }
            }
        }
    }

  }
  
  
  public static boolean canWePlaceWordHorizontally(char[][] arr, String word, int i, int j)
  {
      /* In horizontal direction our row remains same and col changes */
      
      // as we can't place two words with each other horizontally
      if(j-1 >= 0 && arr[i][j-1] != '+')
      {
          return false; // left side of word
      }
      else if(j + word.length() < arr[0].length && arr[i][j + word.length()] != '+')
      {
          return false; // right side of word
      }
      
      // check whether we can place the word or not 
      for(int jj = 0; jj < word.length(); jj++)
      {
          if(j+jj >= arr[0].length)
            return false;
          if(arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj))
            continue;
          else
            return false;
      }
      
      return true;
  }
  
  
  public static boolean canWePlaceWordVertically(char[][] arr, String word, int i, int j)
  {
      /* In vartical direction our col remains same and row changes */
      
      // as we can't place two words with each other vertically
      if(i-1 >= 0 && arr[i - 1][j] != '+')
      {
          return false; // upward side of word
      }
      else if(i + word.length() < arr.length && arr[i+ word.length()][j] != '+')
      {
          return false; // downward side of word
      }
      
      // check whether we can place the word or not 
      for(int ii = 0; ii < word.length(); ii++)
      {
          if(i + ii >= arr.length)
            return false;
          if(arr[i+ ii][j] == '-' || arr[i + ii][j] == word.charAt(ii))
            continue;
          else
            return false;
      }
      
      return true;
  }
  
  public static boolean[] placedTheWordHorizontally(char[][] arr, String word, int i, int j)
  {
      boolean wePlaced[] = new boolean[word.length()];
      
      for(int jj = 0; jj < word.length(); jj++)
      {
          if(arr[i][j+jj] == '-')
          {
              arr[i][j+jj] = word.charAt(jj);
              wePlaced[jj] = true;
          }
      }
      
      return wePlaced;
  }
  
  public static boolean[] placedTheWordVertically(char[][] arr, String word, int i, int j)
  {
      boolean wePlaced[] = new boolean[word.length()];
      
      for(int ii = 0; ii < word.length(); ii++)
      {
          if(arr[i + ii][j] == '-')
          {
              arr[i+ ii][j] = word.charAt(ii);
              wePlaced[ii] = true;
          }
      }
      
      return wePlaced;
  }
  
  public static void unplaceThePlacedWordHorizontally(char[][] arr, boolean placed[], int i, int j)
  {
      for(int jj = 0; jj < placed.length; jj++)
      {
          if(placed[jj] == true)
          {
              arr[i][j + jj] = '-';
          }
      }
  }
  
  public static void unplaceThePlacedWordVertically(char[][] arr, boolean placed[], int i, int j)
  {
      for(int ii = 0; ii < placed.length; ii++)
      {
          if(placed[ii] == true)
          {
              arr[i + ii][j] = '-';
          }
      }
  }


  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}
