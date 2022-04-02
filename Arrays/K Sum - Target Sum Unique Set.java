import java.util.*;
/* 

K Sum - Target Sum Unique Set

1. Given an array nums of 'n' integers and a variable 'K'.
2. You have to return an array of all the unique set [nums[a], nums[b], nums[c], nums[d] . . . K Elements] such that: 
    2.1 a, b, c, d . . . K Elements are less than 'n' and greater than 0.
    2.2 a,. b, c, d upto K different indexes are Unique.
    2.3 nums[a] + nums[b] + nums[c] + nums[d] + . . . + nums[K distinct indexes] == target.
3. You can return answer in any order.


*/

public class Main {
    
    public static ArrayList<ArrayList<Integer>> twoSum(int[] arr, int target, int si) {
    
    int left = si; int right = arr.length-1;
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if(arr.length - si < 2)
        return result;
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
  
  static ArrayList<ArrayList<Integer>> kSumHelper(int[] arr, int target, int k, int si)
  {
    if(k==2)
     return twoSum(arr,target,si);
    
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    int n = arr.length;
    if(n-si < k)return ans;
    for(int i = si; i <= n-k; i++){
        if(i != si && arr[i] == arr[i-1])continue;
        ArrayList<ArrayList<Integer>> subList=kSumHelper(arr, target-arr[i], k-1, i+1);
        for(ArrayList<Integer> x:subList){                
            x.add(arr[i]);
            ans.add(x);
        }
    }
    return ans;
  }
 

  public static ArrayList<ArrayList<Integer>> kSum(int[] arr, int target, int k) {
    Arrays.sort(arr);
    return kSumHelper(arr, target, k, 0);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    int k = scn.nextInt();
    ArrayList<ArrayList<Integer>> res = kSum(arr, target, k);
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
