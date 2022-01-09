/*

Quadruplet Sum - 2

1. You are given four arrays(A1,A2,A3,A4) of integers. All arrays are of same length(N).
2. You have to find the count of all unique quadruplets(a,b,c,d) such that - 
   A1[a] + A2[b] + A3[c] + A4[d] = 0.
   
*/

import java.util.*;

public class Main {
	
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		
		HashMap<Integer, Integer> map = new HashMap<>(); // pair sum and freq
		int count = 0;
		for(int i = 0; i < A.length; i++)
		{
		    for(int j = 0; j < B.length; j++)
		    {
		        map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0)+1);
		    }
		}
		
		int target = 0;
		for(int i = 0; i < C.length; i++)
		{
		    for(int j = 0; j < D.length; j++)
		    {
		       count += map.getOrDefault(target - (C[i]+D[j]), 0);
		    }
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] arr3 = new int[n];
		int[] arr4 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr3[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr4[i] = sc.nextInt();
		}
		System.out.println(fourSumCount(arr1, arr2, arr3, arr4));
	}

}
