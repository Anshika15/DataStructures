import java.util.Scanner;

public class BubbleSort {
	
	void sort(int[] arr)
	{
		int n = arr.length;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n-1-i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
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
		
		BubbleSort obj = new BubbleSort();
		
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

