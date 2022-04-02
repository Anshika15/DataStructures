import java.util.*;

/* 

3 Sum - Target Sum Unique Triplet

1. Given an integer array 'nums', and a 'target', return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k.
2. Another thing is nums[i] + nums[j] + nums[k] == target.
3. Notice that the solution set must not contain duplicate triplets.

*/

public class Main {
    
   public static List<List<Integer>> twoSum(int[] arr, int si, int ei, int target) {
    
    // Arrays.sort(arr);
    
    int left = si; int right = ei;
    List<List<Integer>> result = new ArrayList<>();
    while(left < right)
    {
        if(left != si && arr[left] == arr[left-1])
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

  public static List<List<Integer>> threeSum(int[] nums, int target) {

    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    if(nums.length < 3)
        return res;
    for(int i = 0; i <= nums.length-3; i++)
    {
        if(i != 0 && nums[i] == nums[i-1])
            continue;
        int val1 = nums[i];
        int restTarget = target - val1;
        List<List<Integer>> subRes = twoSum(nums, i+1, nums.length-1, restTarget);
        
        for(List<Integer> l : subRes)
        {
            l.add(val1);
            res.add(new ArrayList<>(l));
        }
    }
        
    return res;

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = threeSum(arr, target);
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
