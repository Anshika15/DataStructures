import java.util.Scanner;
//Move all zeroes to nd of array;
public class MoveAllZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = s.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter the elements of array: ");
		int count = 0;
		for(int i = 0; i < size; i++)
		{
			arr[i] = s.nextInt();
			if(arr[i] == 0)
			{
				count++;
			}
		}
		//System.out.print(count);
		int temp[] = new int[size];
		int j = 0;
		 for(int i = 0; i < size; i++)
		 {
			 if(arr[i] != 0)
			 {
				 temp[j] = arr[i];
				 j++;
			 }
				 
		 }
		 for(int i = 0; i < count; i++)
		 {
			 temp[j] = 0;
			 j++;
		 }
		 for(int i = 0; i < size; i++)
		 {
			 arr[i] = temp[i];
		 }
		 for(int i = 0; i < size; i++)
		 {
			 System.out.print(arr[i] + " ");
		 }

	}

}

