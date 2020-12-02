import java.util.Scanner;

public class InsertionSort {
	
	void sort(int[] arr)
	{
		int n = arr.length;
		int i, j;
		for (i = 1; i < n; i++)
		{
		    int key = arr[i];
		    j = i - 1;
			while(j >= 0 && arr[j] > key)
			{
				 arr[j + 1] = arr[j];  
		         j = j - 1;  
		    }  
		    arr[j + 1] = key;  
		}
		//System.out.println(c);
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
		
		InsertionSort obj = new InsertionSort();
		
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

