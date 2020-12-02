/*  Given two sequences a 1 , a 2 , . . . , a n (a i is the profit per click of the i-th ad) and
     b 1 , b 2 , . . . , b n (b i is the average number of clicks per day of the i-th slot),
     we need to partition them into n pairs (a i , b j )
	such that the sum of their products is maximized.
 */


import java.util.*;
public class MaxAdvertisementRevenue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();
		for (int i = 0; i < n; i++)
			b[i] = s.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		long ans[] = new long[n];
		for (int i = 0; i < n; i++)
			ans[i] = (long)a[i] * b[i];
		
		long sum = 0;
		for (int i = 0; i < n; i++)
			sum += ans[i];
		
		System.out.println("Max Advertisement revenue is: " + sum);

	}

}

