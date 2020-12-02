import java.util.*;
public class GreatestCommonDivisor {
	
	int gcd(int a, int b)
	{
		if(b == 0)
		{
			return a;
		}
		return gcd(b, a%b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		
		GreatestCommonDivisor obj = new GreatestCommonDivisor();
		
		System.out.println(obj.gcd(a,b));
		

	}

}

