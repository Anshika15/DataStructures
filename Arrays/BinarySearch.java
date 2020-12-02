import java.util.*;

//binary search in a sorted array
public class BinarySearch {

	int search(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            if (arr[mid] == x) 
                return mid; 

            if (arr[mid] > x) 
                return search(arr, l, mid - 1, x); 
  
            return search(arr, mid + 1, r, x); 
        } 
   
        return -1; 
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

		System.out.println("Enter the element you want to search: ");
		int element = s.nextInt();
		//Arrays.sort(arr);
		BinarySearch obj = new BinarySearch();
		int index = obj.search(arr, 0, size-1, element);
		
		if(index == -1)
		{
			System.out.println(element + " not found.");
		}
		else
		{
			System.out.println(element + " found.");
		}

	}

}

