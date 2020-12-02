import java.util.*;
public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = s.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter the elements of array: ");
		for (int i = 0; i < size; i++)
		{
			arr[i] = s.nextInt();
		}
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		
		for (int i = 0; i < size; i++)
		{
			set.add(arr[i]);
		}
		Integer array[] = new Integer[set.size()];
		set.toArray(array);
		for(int i = 0; i < set.size(); i++)
		System.out.print(array[i] + " ");

	}

}

