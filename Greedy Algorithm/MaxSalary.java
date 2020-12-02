/*

your boss gives you a few pieces of paper
with numbers on it and asks you to compose a largest number from these numbers. The
resulting number is going to be your salary, so you are very much interested in maximizing
this number.

*/


import java.util.*;
public class MaxSalary {
	
	static void printLargest(ArrayList<Integer> arr)
    {
		String ans = "";
		while(arr.size() != 0)
		{
			int maxdigit = Integer.MIN_VALUE;
			for(int i = 0; i < arr.size(); i++)
			{
				if(IsGreaterOrEqual(arr.get(i), maxdigit))
				{
					maxdigit = arr.get(i);
				}
			}
			ans = ans + maxdigit;
			if(arr.contains(maxdigit))
			arr.remove(new Integer(maxdigit));
		}
		System.out.println("Max Salary Obtained from the given numbers: " + ans);
     
    }
	
	static boolean IsGreaterOrEqual(int digit, int maxdigit)
	{
		String X = "";
		String Y = "";
		X += digit;
		Y += maxdigit;
		String xy = X + Y;
		String yx = Y + X;
		if(xy.compareTo(yx) >= 1)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			arr.add(s.nextInt());
		printLargest(arr);
		
	}
}

