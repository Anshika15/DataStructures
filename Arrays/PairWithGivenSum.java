//find if there is a pair with a given sum

import java.util.*;

public class PairWithGivenSum {
	
	void sum(int[] arr, int s)
	{
		Arrays.sort(arr);
		int l = 0; int r = arr.length - 1;
		while(l < r)
		{
			if(arr[l] + arr[r] == s)
			{
				System.out.println("(" + arr[l] + "," + arr[r] + ") is the pair with given sum");
				return;
			}
			else if((arr[l] + arr[r]) < s)
			{
				l++;
			}
			else
			{
				r--;
			}
		}
		System.out.println("There is no valid pair with given sum.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = s.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter the elements of array: ");
		for(int i = 0; i < size; i++)
		{
			arr[i] = s.nextInt();
		}

		System.out.println("Enter the sum: ");
		int element = s.nextInt();
		
		PairWithGivenSum obj = new PairWithGivenSum();
		
		obj.sum(arr, element);

	}

}

