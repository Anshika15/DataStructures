import java.util.*;

//linear search
public class LinearSearch {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = s.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter the elements of array: ");
		for(int i = 0; i < size; i++)
		{
			arr[i] = s.nextInt();
		}

		System.out.println("Enter the element you want to search: ");
		int element = s.nextInt();
		
		for(int i = 0; i < size; i++)
		{
			if(arr[i] == element)
			{
				System.out.println(element + " found at index " + i);
				return ;
			}
		}
		System.out.println(element + " not found.");
	}

}

