/*
 * Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. 
 * For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 */

import java.util.*;
public class kSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(sol(arr, n, k));

	}
	
	static ArrayList<Integer> sol(int[] arr, int n, int k)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
		{
			pq.add(arr[i]);
			if(pq.size() > k)
				list.add(pq.poll());
		}
		while(pq.size() != 0)
			list.add(pq.poll());
		return list;
	}

}

