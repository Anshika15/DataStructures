/*
 * Given an array of N positive integers, print k largest elements from the array. 
 */

import java.util.*;

public class kLargest {

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
		System.out.println(k_Largest(arr,n,k));

	}
	public static ArrayList<Integer> k_Largest(int arr[], int n, int k)
    {
        // code here 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < n; i++)
        {
            pq.add(arr[i]);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>(pq);
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

}

