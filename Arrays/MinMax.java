import java.util.*;

//find minimum and max element in array
public class MinMax {

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
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0;i < size; i++)
		{
			if(min > arr[i])
			{
				min = arr[i];
			}
		}
		for(int i = 0;i < size; i++)
		{
			if(max < arr[i])
			{
				max = arr[i];
			}
		}
		
		System.out.println("Minimum value is: " + min);
		System.out.println("Maximum value is: " + max);

	}

}

