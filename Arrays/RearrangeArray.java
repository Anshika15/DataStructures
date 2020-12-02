import java.util.*;

//Rearrange an array such that arr[i] = i
/*
 Given an array of elements of length N, ranging from 0 to N – 1.
  All elements may not be present in the array. If the element is not present then there will be -1 present in the array. 
 Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
 */
public class RearrangeArray {

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
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < size; i++)
		{
			set.add(arr[i]);
		}
		for(int i = 0; i < size; i++)
		{
			if(set.contains(i))
				arr[i] = i;
			else
				arr[i] = -1;
		}
		
		for(int i = 0; i < size; i++)
		{
			System.out.print(arr[i] + " ");
		}

	}

}

