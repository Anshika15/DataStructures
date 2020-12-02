//Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
import java.util.*;

public class ArrayRotation {
	
	public void rotate(int arr[], int rs, int n)
	{
		int j = 0;
		int temp[] = new int[n];
		for(int i = rs; i < n ; i++)
		{
			temp[j] = arr[i];
			j++;
		}
		for(int i = 0; i < rs; i++)
		{
			temp[j] = arr[i];
			j++;
		}
		for(int i  = 0; i < n; i++)
		{
			arr[i] = temp[i];
		}
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
		System.out.print("Enter size of rotation: ");
		int d = s.nextInt();
		ArrayRotation obj = new ArrayRotation();
		obj.rotate(arr, d, size);
		
		for(int i = 0; i < size; i++)
		{
			System.out.print(arr[i] + " ");
		}

	}

}

