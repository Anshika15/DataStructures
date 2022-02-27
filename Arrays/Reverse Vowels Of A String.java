import java.util.*;

public class Main {
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static String reverseVowels(String s) {
    char[] arr = s.toCharArray();
        
        int left = 0;
        int right = arr.length-1;
        
        while(left < right)
        {
            // move left pointer to vowel
            while(left < right && !isVowel(arr, left))
                left++;
            // move right pointer to vowel
            while(left < right && !isVowel(arr, right))
                right--;
            swap(arr, left, right);
            left++;
            right--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++)
            sb.append(arr[i] + "");
        
        return sb.toString();
    }
    
    static boolean isVowel(char[] arr, int idx)
    {
        if(arr[idx] == 'a' || arr[idx] == 'e' || arr[idx] == 'i' || arr[idx] == 'o' || arr[idx] == 'u' || arr[idx] == 'A' || arr[idx] == 'E' || arr[idx] == 'I' || arr[idx] == 'O' || arr[idx] == 'U')
            return true;
        return false;
    }
    
    static void swap(char[] arr, int idx1, int idx2)
    {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}
