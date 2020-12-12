import java.util.*;
public class Floor {
	static int res(int[] arr, int start, int end, int x)
	{
		int sol = -1;
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			if(arr[mid] == x)
				return mid;
			else if(arr[mid] > x)
			{
				end = mid - 1;
			}
			else if(arr[mid] < x)
			{
				sol = mid;
				start = mid + 1;
			}
			
		}
		return sol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = s.nextInt();
		}
		int element = s.nextInt();
		System.out.println("index for floor value of " + element + " is " + res(arr, 0, n-1, element));
	}

}

