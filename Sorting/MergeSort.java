import java.util.*;
public class MergeSort {
	
	void sort(int[] arr, int l, int r)
	{
		if(l < r)
		{
			int m = (l + r) / 2;
			
			sort(arr, l , m);
			sort(arr, m + 1, r);
			
			merge(arr, l , m , r);
		}
		
	}
	
	void merge(int[] arr, int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int left[] = new int[n1];
		int right[] = new int[n2];
		
		for(int i = 0; i < n1; i++)
		{
			left[i] = arr[l + i];
		}
		for(int i = 0; i < n2; i++)
		{
			right[i] = arr[m + 1 + i];
		}
		int i = 0, j = 0;
		int k = l;
		
		while(i < n1 && j < n2)
		{
			if(left[i] < right[j])
			{
				arr[k] = left[i];
				i++;
				k++;
			}
			else
			{
				arr[k] = right[j];
				j++;
				k++;
			}
		}
		
		while(i < n1)
		{
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j < n2)
		{
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	void display(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MergeSort obj = new MergeSort();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of Array: ");
		int n = s.nextInt();
		System.out.println("Enter the elements of Array: ");
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = s.nextInt();
		}
		
		obj.sort(arr, 0, n-1);
		
		obj.display(arr);

	}

}

