import java.util.Scanner;

public class HeapSort {
	
	void sort(int[] arr)
	{
		build_max_heap(arr);
		
		for (int i = arr.length - 1; i > 0; i--)
		{
			swap(arr, 0, i);
			
			heapify(arr, 0, i);
		}
		
		
	}
	
	void build_max_heap(int[] arr)
	{
		for(int i = (arr.length / 2) - 1; i >= 0; i--)
		{
			heapify(arr, i, arr.length);
		}
	}
	
	void heapify(int[] arr, int root, int n)
	{
		int max = root;
		int l = 2 * root + 1;
		int r = 2 * root + 2;
		
		if(l < n && arr[l] > arr[max])
			max = l;
		
		if(r < n && arr[r] > arr[max])
			max = r;
		
		if(max != root)
		{
			swap(arr, root, max);
			
			heapify(arr, max, n);
		}
	}
	
	void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	void display(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HeapSort obj = new HeapSort();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of Array: ");
		int n = s.nextInt();
		System.out.println("Enter the elements of Array: ");
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = s.nextInt();
		}
		
		obj.sort(arr);
		
		obj.display(arr);

	}

}

