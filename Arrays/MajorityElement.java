import java.util.*;
public class MajorityElement {
	
	static int maxElement(int[] arr, int n)
	{
		int count = 1;
		int temp = arr[0];
		int flag = 0;
		int max_element = -1;
		int element = -1;
		for(int i = 1; i < n; i++)
		{
			if(temp == arr[i])
				count++;
			else
			{
				count = 1;
				temp = arr[i];
			}
			
			if(max_element < count)
	        {
	            max_element = count;
	            element = arr[i];
	             
	            if(max_element > (n/2))
	            {
	                flag = 1;
	                break;
	            }
	        }
		}
		return (flag == 1 ? element : -1 );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		Arrays.sort(arr);
		
		int f = maxElement(arr, n);
		if(f == -1)
			System.out.println("0");
		else
			System.out.println("1");
			

	}

}

