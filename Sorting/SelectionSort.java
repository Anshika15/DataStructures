import java.util.Scanner;

public class SelectionSort {
	
	void sort(int[] arr)
	{
		int n = arr.length; 
		  
        for (int i = 0; i < n-1; i++) 
        {  
            int small = i;
            for(int j = i+1; j < n; j++) //find the smallest element in the unsorted array
            {
            	if(arr[j] < arr[small])
            	{
            		small = j;
            	}
            }
            
            int temp = arr[small];
            arr[small] = arr[i];
            arr[i] = temp;
        } 
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
		
		SelectionSort obj = new SelectionSort();
		
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

