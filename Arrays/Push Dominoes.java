import java.util.*;

public class Main {

  /* 
  
  Push Dominoes
  
  1. There are n dominoes in a line, and we place each domino vertically upright.
2. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
3. After each second, each domino that is falling to the left pushes the adjacent domino on the left. 
4. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
5. When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
6. For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
7. You are given a string dominoes representing the initial state where:
    a). dominoes[i] = 'L', if the ith domino has been pushed to the left,
    b). dominoes[i] = 'R', if the ith domino has been pushed to the right, and
    c). dominoes[i] = '.', if the ith domino has not been pushed.
8. Return a string representing the final state.
  
  */
  public static String pushDominoes(String str) {
    /* 
    
    case1 => L ........ L => impact => L LLLLL L
    
    case2 => R ........ R => impcat => R RRRRR R
    
    case3 => L ........ R => impact => L ..... R
    
    case4 => R ........ L => impact =>
        i) if even tiles in betwwen => make helf r and half L
        
        ii) if odd tiles in between => make half R, half L except middle one
    
    
    */
    
    int n = str.length();
    char[] arr = new char[n+2];
    arr[0] = 'L';
    arr[n+1] = 'R';
    
    for(int i = 1; i < arr.length-1; i++)
    {
        arr[i] = str.charAt(i-1);
    }
    
    int j = 0;
    int k = 1;
    while(k < arr.length)
    {
        while(arr[k] == '.')
            k++;
        if(k-j > 1)
            solveConfiguration(j, k, arr);
        j = k;
        k++;
    }
    // our ans is present in 1 to n idx
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < arr.length-1; i++)
        sb.append(arr[i] + "");
        
    return sb.toString();
  }
  
  public static void solveConfiguration(int i, int j, char[] arr)
  {
      if(arr[i] == 'L' && arr[j] == 'L')
      {
        // make all dots L  
        for(int k = i+1; k < j; k++)
            arr[k] = 'L';
      }
      else if(arr[i] == 'L' && arr[j] == 'R')
      {
         // nothing to do 
      }
      else if(arr[i] == 'R' && arr[j] == 'R')
      {
          // make all dots R
          for(int k = i+1; k < j; k++)
            arr[k] = 'R';
      }
      else
      {
         // solve acc to even and odd count
         if((j-i-1)%2 == 0)
         {
             // even
             int mid = (i+j)/2;
             // i+1 to mid => R
             // mid+1 to j => L
             for(int k = i+1; k <= mid; k++)
             {
                 arr[k] = 'R';
             }
             for(int k = mid+1; k < j; k++)
             {
                 arr[k] = 'L';
             }
         }
         else
         {
             // odd
             int mid = (i+j)/2;
             // i+1 to mid-1 => R
             // mid+1 to j => L
             for(int k = i+1; k < mid; k++)
             {
                 arr[k] = 'R';
             }
             for(int k = mid+1; k < j; k++)
             {
                 arr[k] = 'L';
             }
         }
      }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String res = pushDominoes(str);
    System.out.println(res);
  }
}
