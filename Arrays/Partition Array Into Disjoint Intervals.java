import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~User''s Section~~~~~~~~~~~~~~~
  public static int partitionDisjoint(int[] arr) {
    // find right min and left max for a particular element
    // max from left will check for min from right min array for the next element
    


    // 1 make a right min array
    // 2 maintain left max and find partition index
    int rightMin[] = new int[arr.length+1];
    rightMin[arr.length] = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    for(int i = arr.length-1; i >= 0; i--)
    {
      rightMin[i] = Math.min(min, arr[i]);
      min = rightMin[i];
    }

    int lmax = 0;
    for(int i = 0; i < arr.length; i++)
    {
      lmax = Math.max(lmax, arr[i]);
      if(lmax < rightMin[i+1])
        return i+1;
    }
    return -1;
  }

  // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int len = partitionDisjoint(arr);
    System.out.println(len);
  }
}
