import java.util.*;

public class Main {
    
    /* 
    
    2 Sum - Target Sum Unique Pairs
    
    1. Given an Array of size 'n' have may or may not be repeated elements.
2. A 'target' is provided.
3. Return Pair of target sum in which all pairs are unique, for example : [1, 2], [2, 1] are consider as same pair.
4. If array have repeated element then return only unique pair, for example : if array is arr = [2, 2, 4, 4], and target = 6 then res have only one pair, i.e. [2, 4]
    
    */

  public static List<List<Integer>> twoSum(int[] arr, int target) {
    
    Arrays.sort(arr);
    
    int left = 0; int right = arr.length-1;
    List<List<Integer>> result = new ArrayList<>();
    while(left < right)
    {
        if(left != 0 && arr[left] == arr[left-1])
        {
            left++;
            continue;
        }
        int sum = arr[left] + arr[right];
        if(sum == target)
        {
            result.add(new ArrayList<>(Arrays.asList(arr[left], arr[right])));
            left++;
            right--;
        }
        else if(sum > target)
        {
            right--;
        }
        else
        {
            left++;
        }
    }
    return result;
    
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = twoSum(arr, target);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }
}
