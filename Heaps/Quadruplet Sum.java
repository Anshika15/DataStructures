/*

Quadruplet Sum

1. You are given an array(arr) of N integers and an integer X.
2. You have to find all unique quadruplets(a,b,c,d) which satisfies this condition - 
   a+b+c+d = X
   
*/

import java.util.*;

public class Main {
    
    /* O(n^3) solution using twosum and threesum */
    
    /*
    public static void createRes(ArrayList<ArrayList<Integer>> res, ArrayList<ArrayList<Integer>> smallAns, int val)
    {
        for(ArrayList<Integer> sa : smallAns)
        {
            sa.add(0, val);
            res.add(sa);
        }
    }
    
    public static ArrayList<ArrayList<Integer>> twoSum(int[] nums, int target, int si, int ei) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		while(si < ei)
		{
		    int sum = nums[si] + nums[ei];
		    if(sum > target) ei--;
		    else if(sum < target) si++;
		    else
		    {
		        res.add(new ArrayList(Arrays.asList(nums[si], nums[ei])));
		        si++;
		        ei--;
		        while(si < ei && nums[si] == nums[si-1]) si++;
		        while(si < ei && nums[ei] == nums[ei+1]) ei--;
		    }
		}
		
		return res;
	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(int[] nums, int target, int si, int ei) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    
	    for(int i = si; i <= ei; i++)
	    {
	        if(i != si && nums[i] == nums[i-1]) continue;
	        
	        ArrayList<ArrayList<Integer>> smallAns = twoSum(nums, target - nums[i], i+1, ei);
	        createRes(res, smallAns, nums[i]);
	        
	        
	    }
	    
	    return res;
	}
	
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
        Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    int si = 0;
	    int ei = n-1;
	    for(int i = si; i <= ei; i++)
	    {
	        if(i != si && nums[i] == nums[i-1]) continue;
	        
	        ArrayList<ArrayList<Integer>> smallAns = threeSum(nums, target - nums[i], i+1, ei);
	        createRes(res, smallAns, nums[i]);
	        
	        
	    }
	    
	    return res;
	}

    */
    
    
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
        Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    for(int i = 0; i < n; i++)
	    {
	        if(i != 0 && nums[i] == nums[i-1])
	            continue;
	        for(int j = i+1; j < n; j++)
	        {
	            if(j != i+1 && nums[j] == nums[j-1])
	                continue;
	            int si = j+1;
	            int ei = n-1;
	            while(si < ei)
	            {
	                int sum = nums[i] + nums[j] + nums[si] + nums[ei];
	                
	                if(sum > target) ei--;
		            else if(sum < target) si++;
		            else
		            {
		               res.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[si], nums[ei])));
		               si++;
		               ei--;
		               while(si < ei && nums[si] == nums[si-1]) si++;
		               while(si < ei && nums[ei] == nums[ei+1]) ei--;
		          }
	            }
	        }
	    }
	    
	    return res;
	}
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
		Collections.sort(ans,(a,b)->{
            int i = 0;
            int j = 0;
            
            while(i < a.size()){
                if(a.get(i) == b.get(j)){
                    i++;
                    j++;
                }else{
                    return a.get(i) - b.get(j);
                }
            }
            
            return 0;
        }); 
		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

}
