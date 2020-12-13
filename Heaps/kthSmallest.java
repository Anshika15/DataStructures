import java.util.*;

public class kthSmallest {

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
	static int sol(int[] arr, int n, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			pq.add(arr[i]);
			if(pq.size() > k)
			{
				pq.poll();
			}
		}
		return pq.poll();
	}

}

