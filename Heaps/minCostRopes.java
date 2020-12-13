/*
There are given N ropes of different lengths, we need to connect these ropes into one rope. 
The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.
*/

import java.util.*;
public class minCostRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long arr[] = new long[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = s.nextInt();
		}
		System.out.println(minCost(arr, n));

	}
	static long minCost(long arr[], int n) {
        // your code here
        long cost = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(int i = 0; i < n; i++)
            pq.add(arr[i]);
        while(pq.size() >= 2)
        {
            long first = pq.poll();
            long second = pq.poll();
            cost += first + second;
            pq.add(first + second);
        }
        return cost;
    }

}

