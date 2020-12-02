/*
 	The goal in this problem is to find the minimum number of coins needed to change the input value
	(an integer) into coins with denominations 1, 5, and 10.
 */
import java.util.*;

public class MoneyChange {
	
	int change(int m)
	{
		int val = 0;
		int coins = 0;
		int[] arr = {1, 5, 10};
		for(int i = arr.length - 1; i >= 0; i--)
		{
			while(m >= arr[i])
			{
				val = val + arr[i];
				m = m - arr[i];
				coins++;
			}	
		}
		return coins;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MoneyChange obj = new MoneyChange();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter the Amount: ");
		int m = s.nextInt();

		
		int mincoins = obj.change(m);
		
		System.out.println("mincoins required to create the change is: "+ mincoins);

	}

}

